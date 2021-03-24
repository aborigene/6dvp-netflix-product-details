package com.dvp6.grupo1.product_details;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MovieRepository extends CrudRepository<Movie, String>  {
    List<Movie> findByTitle(String title);
    List<Movie> findByType(String type);
    Optional<Movie> findById(String imdbid);
    //@Query("SELECT m FROM Movie m WHERE LOWER(m.title) like '%LOWER(:title)%'")
    List<Movie> findByTitleContaining(String title);
    List<Movie> findByYear(String year);
    List<Movie> findByTitleAndYear(String title, String year);
    

}
