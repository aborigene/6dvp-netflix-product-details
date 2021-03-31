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

    List<Movie> findTopByTitleContainingIgnoreCase(String title);
    List<Movie> findTop5ByTitleContainingIgnoreCase(String title);
    List<Movie> findTop10ByTitleContainingIgnoreCase(String title);
    List<Movie> findTop20ByTitleContainingIgnoreCase(String title);

    List<Movie> findTopByTitleContainingIgnoreCaseOrderByLikes(String title);
    List<Movie> findTop5ByTitleContainingIgnoreCaseOrderByLikes(String title);
    List<Movie> findTop10ByTitleContainingIgnoreCaseOrderByLikes(String title);
    List<Movie> findTop20ByTitleContainingIgnoreCaseOrderByLikes(String title);

    List<Movie> findTopByTitleContainingIgnoreCaseOrderByDislikes(String title);
    List<Movie> findTop5ByTitleContainingIgnoreCaseOrderByDislikes(String title);
    List<Movie> findTop10ByTitleContainingIgnoreCaseOrderByDislikes(String title);
    List<Movie> findTop20ByTitleContainingIgnoreCaseOrderByDislikes(String title);

    List<Movie> findTopByGenreContainingIgnoreCase(String genre);
    List<Movie> findTop5ByGenreContainingIgnoreCase(String genre);
    List<Movie> findTop10ByGenreContainingIgnoreCase(String genre);
    List<Movie> findTop20ByGenreContainingIgnoreCase(String genre);

    List<Movie> findTopByGenreContainingIgnoreCaseOrderByLikes(String genre);
    List<Movie> findTop5ByGenreContainingIgnoreCaseOrderByLikes(String genre);
    List<Movie> findTop10ByGenreContainingIgnoreCaseOrderByLikes(String genre);
    List<Movie> findTop20ByGenreContainingIgnoreCaseOrderByLikes(String genre);

    List<Movie> findTopByGenreContainingIgnoreCaseOrderByDislikes(String genre);
    List<Movie> findTop5ByGenreContainingIgnoreCaseOrderByDislikes(String genre);
    List<Movie> findTop10ByGenreContainingIgnoreCaseOrderByDislikes(String genre);
    List<Movie> findTop20ByGenreContainingIgnoreCaseOrderByDislikes(String genre);

}
