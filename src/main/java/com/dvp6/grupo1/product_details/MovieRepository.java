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
    
    List<Movie> findByYear(String year);
    List<Movie> findByTitleAndYear(String title, String year);
    @Query("SELECT m FROM Movie m WHERE LOWER(m.title) like '%LOWER(:title)%' and m.year = ':year'")
    List<Movie> searchByTitleAndYear(String title, String year);
    List<Movie> findByGenre(String genre);

    List<Movie> findTopByTitleContaining(String title);
    List<Movie> findTop5ByTitleContaining(String title);
    List<Movie> findTop10ByTitleContaining(String title);
    List<Movie> findTop20ByTitleContaining(String title);

    List<Movie> findTopByTitleContainingOrderByLikes(String title);
    List<Movie> findTop5ByTitleContainingOrderByLikes(String title);
    List<Movie> findTop10ByTitleContainingOrderByLikes(String title);
    List<Movie> findTop20ByTitleContainingOrderByLikes(String title);

    List<Movie> findTopByTitleContainingOrderByDislikes(String title);
    List<Movie> findTop5ByTitleContainingOrderByDislikes(String title);
    List<Movie> findTop10ByTitleContainingOrderByDislikes(String title);
    List<Movie> findTop20ByTitleContainingOrderByDislikes(String title);

    List<Movie> findTopByGenreContaining(String genre);
    List<Movie> findTop5ByGenreContaining(String genre);
    List<Movie> findTop10ByGenreContaining(String genre);
    List<Movie> findTop20ByGenreContaining(String genre);

    List<Movie> findTopByGenreContainingOrderByLikes(String genre);
    List<Movie> findTop5ByGenreContainingOrderByLikes(String genre);
    List<Movie> findTop10ByGenreContainingOrderByLikes(String genre);
    List<Movie> findTop20ByGenreContainingOrderByLikes(String genre);

    List<Movie> findTopByGenreContainingOrderByDislikes(String genre);
    List<Movie> findTop5ByGenreContainingOrderByDislikes(String genre);
    List<Movie> findTop10ByGenreContainingOrderByDislikes(String genre);
    List<Movie> findTop20ByGenreContainingOrderByDislikes(String genre);

}
