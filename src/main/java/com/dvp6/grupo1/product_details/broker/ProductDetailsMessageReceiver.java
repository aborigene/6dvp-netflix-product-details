package com.dvp6.grupo1.product_details.broker;

import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import com.dvp6.grupo1.product_details.model.MovieEntity;
import com.dvp6.grupo1.product_details.model.MovieRepository;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.util.Optional;

@Component
public class ProductDetailsMessageReceiver {

    @Autowired
    private MovieRepository movieRepository;

    @RabbitListener(queues = ProductDetailsBrokerConfig.QUEUE)
    public void receiveMessage(byte[] message_bytes) {
        String message = new String(message_bytes, StandardCharsets.UTF_8);
        JsonReader jsonReader = new JsonReader(new StringReader(message));
        jsonReader.setLenient(true);
		JsonObject jsonObject = JsonParser.parseReader(jsonReader).getAsJsonObject();
        String imdbid = jsonObject.get("imdbid").getAsString();
        int like = jsonObject.get("like").getAsInt();
        int dislike = jsonObject.get("dislike").getAsInt();

        Optional<MovieEntity> movieToUpdateOptional = movieRepository.findById(imdbid);

        if (movieToUpdateOptional.isPresent()){
            MovieEntity movieToUpdate = movieToUpdateOptional.get();
            if (like == 1) movieToUpdate.setLikes(movieToUpdate.getLikes()+1);
            else if (dislike == 1) movieToUpdate.setDislikes(movieToUpdate.getDislikes()+1);
            movieToUpdate.setViews(movieToUpdate.getViews()+1);            
            movieRepository.save(movieToUpdate);
            System.out.println("Movie " + movieToUpdate.getTitle() + "updated. Likes: " + movieToUpdate.getLikes() + ", Dislikes: " + movieToUpdate.getDislikes());
        }        
    }

}