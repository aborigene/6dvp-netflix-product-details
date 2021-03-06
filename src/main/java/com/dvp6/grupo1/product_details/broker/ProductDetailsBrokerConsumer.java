/*
  Autor: Guilherme Rubio
  e-mail: guilherme.rubio@outlook.com.br
  Data: 24/04/2021
*/

package com.dvp6.grupo1.product_details.broker;

import com.dvp6.grupo1.product_details.model.MovieEntity;
import com.dvp6.grupo1.product_details.model.MovieRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
  Classe responsável por consumir as filas no RabbitMQ.
*/
@Component
public class ProductDetailsBrokerConsumer {

    @Autowired
    private MovieRepository movieRepository;

    /*
     * Método para ler a fila e salvas os dados no banco.
     */
    @RabbitListener(queues = ProductDetailsBrokerConfig.QUEUE)
    public void consumer(Message message) throws JsonMappingException, JsonProcessingException {

        Logger log = LoggerFactory.getLogger(ProductDetailsBrokerConsumer.class);

        try {
            String json = null;
            String likeOrDislike = null;
            int increment = 0;
            ObjectMapper mapper = new ObjectMapper();

            /*
             * Lendo as propriedades do json da fila
             */
            MovieEntity movieEntity = mapper.readValue(new String(message.getBody()), MovieEntity.class);
            if (movieEntity.getLikes() == 1) {
                likeOrDislike = "like";
                increment++;
            }
            if (movieEntity.getDislikes() == 1) {
                likeOrDislike = "dislike";
                increment++;
            }

            /*
             * Carregando as informações do banco de dados com base no elemento "IMDBID" que
             * foi lido da fila
             */
            json = mapper.writeValueAsString(movieRepository.findByImdbid(movieEntity.getImdbid()));
            movieEntity = mapper.readValue(json.replace("[", "").replace("]", ""), MovieEntity.class);
            if (likeOrDislike.equals("like")) {
                movieEntity.setLikes(movieEntity.getLikes() + increment);
            }
            if (likeOrDislike.equals("dislike")) {
                movieEntity.setDislikes(movieEntity.getDislikes() + increment);
            }

            /*
             * Update do banco de dados incrementando o like ou dislike
             */
            movieRepository.save(movieEntity);

        } catch (JsonProcessingException e) {
            log.error("Error: ", e);
        }

    }
}