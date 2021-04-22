package com.dvp6.grupo1.product_details.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "imdbid")
    private String imdbid;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private String year;

    @Column(name = "type")
    private String type;

    @Column(name = "poster")
    private String poster;

    @Column(name = "genre")
    private String genre;

    @Column(name = "likes")
    private long likes;

    @Column(name = "dislikes")
    private long dislikes;

    @Column(name = "views")
    private long views;

    public MovieEntity() {
    }

    public MovieEntity(String imdbid, String title, String year, String type, String poster, String genre, long likes,
            long dislikes, long views) {
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

    /*
     * Métodos Getters e Setters.
     */
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImdbid() {
        return this.imdbid;
    }

    public void setImdbid(String imdbid) {
        this.imdbid = imdbid;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPoster() {
        return this.poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public long getLikes() {
        return this.likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public long getDislikes() {
        return this.dislikes;
    }

    public void setDislikes(long dislikes) {
        this.dislikes = dislikes;
    }

    public long getViews() {
        return this.views;
    }

    public void setViews(long views) {
        this.views = views;
    }

}
