package com.dvp6.grupo1.product_details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.*;

//import javax.swing.table.DefaultTableCellRenderer;

import com.google.gson.*;

@RestController
public class ProductDetailsController { 
	@Autowired
	MovieRepository movieRepository;// = new MovieRepository();

    @RequestMapping(method = RequestMethod.GET, value = "/api/movies_by_genre")
    @ResponseBody
	public ResponseEntity<String> moviesByGenre(@RequestParam(name = "genre") String genre, @RequestParam(name = "top", required = false, defaultValue = "1") Integer top, @RequestParam(name = "order_by") String order_by) {

		List<Movie> movie;
		if(order_by.equals("likes")){
			switch(top){
				case 5:
					movie = movieRepository.findTop5ByGenreContainingOrderByLikes(genre);
					break;
				case 10:
					movie = movieRepository.findTop10ByGenreContainingOrderByLikes(genre);
					break;
				case 20: 
					movie = movieRepository.findTop20ByGenreContainingOrderByLikes(genre);
					break;
				default:
					movie = movieRepository.findTopByGenreContainingOrderByLikes(genre);
			} 
		}
		else{
			if(order_by.equals("dislikes")){
				switch(top){
					case 5:
						movie = movieRepository.findTop5ByGenreContainingOrderByDislikes(genre);
						break;
					case 10:
						movie = movieRepository.findTop10ByGenreContainingOrderByDislikes(genre);
						break;
					case 20: 
						movie = movieRepository.findTop20ByGenreContainingOrderByDislikes(genre);
						break;
					default:
						movie = movieRepository.findTopByGenreContainingOrderByDislikes(genre);
				}
			}
			else{
				if(order_by.equals("none")){
					switch(top){
						case 5:
							movie = movieRepository.findTop5ByGenreContaining(genre);
							break;
						case 10:
							movie = movieRepository.findTop10ByGenreContaining(genre);
							break;
						case 20: 
							movie = movieRepository.findTop20ByGenreContaining(genre);
							break;
						default:
							movie = movieRepository.findTopByGenreContaining(genre);
					}	
				}
				else {
					Map<String, String> responseMessage = new HashMap<String,String>();
					responseMessage.put("erroCode",HttpStatus.BAD_REQUEST.toString());
					responseMessage.put("Message","Wrong order_by parameter informed. Please inform likes, dislikes or none. Anything else will trhow an error.");
					return new ResponseEntity<String>(new Gson().toJson(responseMessage), HttpStatus.BAD_REQUEST);
				}
			}
		}
		
		return new ResponseEntity<String>(new Gson().toJson(movie), HttpStatus.OK);
	}    

	@RequestMapping(method = RequestMethod.GET, value = "/api/movie_search")
    @ResponseBody
	public ResponseEntity<String> moviesSearch(@RequestParam(name = "title_search") String title_search, @RequestParam(name = "top", required = false, defaultValue = "1") Integer top, @RequestParam(name = "order_by") String order_by) {
		List<Movie> movie;
		if(order_by.equals("likes")){
			switch(top){
				case 5:
					movie = movieRepository.findTop5ByTitleContainingOrderByLikes(title_search);
					break;
				case 10:
					movie = movieRepository.findTop10ByTitleContainingOrderByLikes(title_search);
					break;
				case 20: 
					movie = movieRepository.findTop20ByTitleContainingOrderByLikes(title_search);
					break;
				default:
					movie = movieRepository.findTopByTitleContainingOrderByLikes(title_search);
			}
		}
		else{
			if(order_by.equals("dislikes")){
				switch(top){
					case 5:
						movie = movieRepository.findTop5ByTitleContainingOrderByDislikes(title_search);
						break;
					case 10:
						movie = movieRepository.findTop10ByTitleContainingOrderByDislikes(title_search);
						break;
					case 20: 
						movie = movieRepository.findTop20ByTitleContainingOrderByDislikes(title_search);
						break;
					default:
						movie = movieRepository.findTopByTitleContainingOrderByDislikes(title_search);
				}			
			}
			else{
				if(order_by.equals("none")){
					switch(top){
						case 5:
							movie = movieRepository.findTop5ByTitleContaining(title_search);
							break;
						case 10:
							movie = movieRepository.findTop10ByTitleContaining(title_search);
							break;
						case 20: 
							movie = movieRepository.findTop20ByTitleContaining(title_search);
							break;
						default:
							movie = movieRepository.findTopByTitleContaining(title_search);
					}
				}
				else{
					Map<String, String> responseMessage = new HashMap<String,String>();
					responseMessage.put("erroCode",HttpStatus.BAD_REQUEST.toString());
					responseMessage.put("Message","Wrong order_by parameter informed. Please inform likes, dislikes or none. Anything else will trhow an error.");
					return new ResponseEntity<String>(new Gson().toJson(responseMessage), HttpStatus.BAD_REQUEST);
				}
			}
		}
		

		return new ResponseEntity<String>(new Gson().toJson(movie), HttpStatus.OK);

	}	
}
