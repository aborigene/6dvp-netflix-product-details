package com.dvp6.grupo1.product_details;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.google.gson.*;

@Entity
public class Movie {
@Id
private String imdbid;
private String title;
private String year;
private String type;
private String poster;
private String genre;
private int likes;
private int dislikes;
private int views;

protected Movie() {}

public Movie(String imdbid, String title, String year, String type, String poster, String genre, int likes, int dislikes, int views){
    this.imdbid = imdbid;
    this.title = title;
    this.year = year;
    this.type = type;
    this.poster = poster;
    this.genre = genre;
    this.likes = likes;
    this.likes = dislikes;
    this.views = views;
}

@Override
public String toString(){
    return String.format("Movie[imdbid=%s, title='%s', year='%s', type='%s', poster='%s', genre='%s', likes='%d', dislikes='%d', views='%d']", imdbid, title, year, type, poster, genre, likes, dislikes, views);
}

public String toJson(){
    return new Gson().toJson(this);
}

public String getId(){
    return this.imdbid;
}

public String getTitle(){
    return this.title;
}

public String getYear(){
    return this.year;
}

public String getType(){
    return this.type;
}

public String getPoster(){
    return this.poster;
}

public String getGenre(){
    return this.genre;
}

public int getLikes(){
    return this.likes;
}

public int getDislikes(){
    return this.dislikes;
}

public int getViews(){
    return this.views;
}

public void setLikes(int likes){
    this.likes = likes;
}

public void setViews(int views){
    this.views = views;
}

public void setDislikes(int dislikes){
    this.dislikes = dislikes;
}

}
