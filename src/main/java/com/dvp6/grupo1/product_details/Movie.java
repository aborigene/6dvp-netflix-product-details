package com.dvp6.grupo1.product_details;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
@Id
private String imdbid;
private String title;
private String year;
private String type;
private String poster;

protected Movie() {}

public Movie(String imdbid, String title, String year, String type, String poster){
    this.imdbid = imdbid;
    this.title = title;
    this.year = year;
    this.type = type;
    this.poster = poster;
}

@Override
public String toString(){
    return String.format("Movie[imdbid=%s, title='%s', year='%s', type='%s', poster='%s']", imdbid, title, year, type, poster);
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

}
