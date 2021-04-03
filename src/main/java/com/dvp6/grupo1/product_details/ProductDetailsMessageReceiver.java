package com.dvp6.grupo1.product_details;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.util.Optional;

@Component
public class ProductDetailsMessageReceiver {

    @Autowired
    private MovieRepository movieRepository;

    public void receiveMessage(byte[] message_bytes) {
        String message = new String(message_bytes, StandardCharsets.UTF_8);
        JsonReader jsonReader = new JsonReader(new StringReader(message));
        jsonReader.setLenient(true);
        JsonObject jsonObject = new JsonParser().parse(jsonReader).getAsJsonObject();
        String imdbid = jsonObject.get("imdbid").getAsString();
        int like = jsonObject.get("like").getAsInt();
        int dislike = jsonObject.get("dislike").getAsInt();

        Optional<Movie> movieToUpdateOptional = movieRepository.findById(imdbid);

        if (movieToUpdateOptional.isPresent()){
            Movie movieToUpdate = movieToUpdateOptional.get();
            if (like == 1) movieToUpdate.setLikes(movieToUpdate.getLikes()+1);
            else if (dislike == 1) movieToUpdate.setDislikes(movieToUpdate.getDislikes()+1);
            movieToUpdate.setViews(movieToUpdate.getViews()+1);            
            movieRepository.save(movieToUpdate);
            System.out.println("Movie " + movieToUpdate.getTitle() + "updated. Likes: " + movieToUpdate.getLikes() + ", Dislikes: " + movieToUpdate.getDislikes());
        }        
    }

}