package com.dvp6.grupo1.product_details.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long>  {
    List<MovieEntity> findByTitle(String title);
    List<MovieEntity> findByType(String type);
    Optional<MovieEntity> findById(String imdbid);
    
    List<MovieEntity> findByYear(String year);
    List<MovieEntity> findByTitleAndYear(String title, String year);
    //@Query("SELECT m FROM Movie m WHERE LOWER(m.title) like '%LOWER(:title)%' and m.year = ':year'")
    //List<MovieEntity> searchByTitleAndYear(String title, String year);
    List<MovieEntity> findByGenre(String genre);

    List<MovieEntity> findTopByTitleContainingIgnoreCase(String title);
    List<MovieEntity> findTop5ByTitleContainingIgnoreCase(String title);
    List<MovieEntity> findTop10ByTitleContainingIgnoreCase(String title);
    List<MovieEntity> findTop20ByTitleContainingIgnoreCase(String title);

    List<MovieEntity> findTopByTitleContainingIgnoreCaseOrderByLikes(String title);
    List<MovieEntity> findTop5ByTitleContainingIgnoreCaseOrderByLikes(String title);
    List<MovieEntity> findTop10ByTitleContainingIgnoreCaseOrderByLikes(String title);
    List<MovieEntity> findTop20ByTitleContainingIgnoreCaseOrderByLikes(String title);

    List<MovieEntity> findTopByTitleContainingIgnoreCaseOrderByDislikes(String title);
    List<MovieEntity> findTop5ByTitleContainingIgnoreCaseOrderByDislikes(String title);
    List<MovieEntity> findTop10ByTitleContainingIgnoreCaseOrderByDislikes(String title);
    List<MovieEntity> findTop20ByTitleContainingIgnoreCaseOrderByDislikes(String title);

    List<MovieEntity> findTopByGenreContainingIgnoreCase(String genre);
    List<MovieEntity> findTop5ByGenreContainingIgnoreCase(String genre);
    List<MovieEntity> findTop10ByGenreContainingIgnoreCase(String genre);
    List<MovieEntity> findTop20ByGenreContainingIgnoreCase(String genre);

    List<MovieEntity> findTopByGenreContainingIgnoreCaseOrderByLikes(String genre);
    List<MovieEntity> findTop5ByGenreContainingIgnoreCaseOrderByLikes(String genre);
    List<MovieEntity> findTop10ByGenreContainingIgnoreCaseOrderByLikes(String genre);
    List<MovieEntity> findTop20ByGenreContainingIgnoreCaseOrderByLikes(String genre);

    List<MovieEntity> findTopByGenreContainingIgnoreCaseOrderByDislikes(String genre);
    List<MovieEntity> findTop5ByGenreContainingIgnoreCaseOrderByDislikes(String genre);
    List<MovieEntity> findTop10ByGenreContainingIgnoreCaseOrderByDislikes(String genre);
    List<MovieEntity> findTop20ByGenreContainingIgnoreCaseOrderByDislikes(String genre);

}
