package com.dvp6.grupo1.product_details.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dvp6.grupo1.product_details.model.MovieEntity;
import com.dvp6.grupo1.product_details.model.MovieRepository;
import com.google.gson.Gson;

@RestController
public class ProductDetailsController {

	@Autowired
	private MovieRepository movieRepository;

	@GetMapping("/moviesByGenre")
	public ResponseEntity<String> moviesByGenre(@RequestParam(name = "genre") String genre,
			@RequestParam(name = "top", required = false, defaultValue = "1") Integer top,
			@RequestParam(name = "order_by") String order_by) {

		List<MovieEntity> movie;
		if (order_by.equals("likes")) {
			switch (top) {
			case 5:
				movie = movieRepository.findTop5ByGenreContainingIgnoreCaseOrderByLikes(genre);
				break;
			case 10:
				movie = movieRepository.findTop10ByGenreContainingIgnoreCaseOrderByLikes(genre);
				break;
			case 20:
				movie = movieRepository.findTop20ByGenreContainingIgnoreCaseOrderByLikes(genre);
				break;
			default:
				movie = movieRepository.findTopByGenreContainingIgnoreCaseOrderByLikes(genre);
			}
		} else {
			if (order_by.equals("dislikes")) {
				switch (top) {
				case 5:
					movie = movieRepository.findTop5ByGenreContainingIgnoreCaseOrderByDislikes(genre);
					break;
				case 10:
					movie = movieRepository.findTop10ByGenreContainingIgnoreCaseOrderByDislikes(genre);
					break;
				case 20:
					movie = movieRepository.findTop20ByGenreContainingIgnoreCaseOrderByDislikes(genre);
					break;
				default:
					movie = movieRepository.findTopByGenreContainingIgnoreCaseOrderByDislikes(genre);
				}
			} else {
				if (order_by.equals("none")) {
					switch (top) {
					case 5:
						movie = movieRepository.findTop5ByGenreContainingIgnoreCase(genre);
						break;
					case 10:
						movie = movieRepository.findTop10ByGenreContainingIgnoreCase(genre);
						break;
					case 20:
						movie = movieRepository.findTop20ByGenreContainingIgnoreCase(genre);
						break;
					default:
						movie = movieRepository.findTopByGenreContainingIgnoreCase(genre);
					}
				} else {
					Map<String, String> responseMessage = new HashMap<String, String>();
					responseMessage.put("erroCode", HttpStatus.BAD_REQUEST.toString());
					responseMessage.put("Message",
							"Wrong order_by parameter informed. Please inform likes, dislikes or none. Anything else will trhow an error.");
					return new ResponseEntity<String>(new Gson().toJson(responseMessage), HttpStatus.BAD_REQUEST);
				}
			}
		}
		return new ResponseEntity<String>(new Gson().toJson(movie), HttpStatus.OK);

	}

	@GetMapping("/movieSearch")
	public ResponseEntity<String> moviesSearch(@RequestParam(name = "title_search") String title_search,
			@RequestParam(name = "top", required = false, defaultValue = "1") Integer top,
			@RequestParam(name = "order_by") String order_by) {
		List<MovieEntity> movie;
		if (order_by.equals("likes")) {
			switch (top) {
			case 5:
				movie = movieRepository.findTop5ByTitleContainingIgnoreCaseOrderByLikes(title_search);
				break;
			case 10:
				movie = movieRepository.findTop10ByTitleContainingIgnoreCaseOrderByLikes(title_search);
				break;
			case 20:
				movie = movieRepository.findTop20ByTitleContainingIgnoreCaseOrderByLikes(title_search);
				break;
			default:
				movie = movieRepository.findTopByTitleContainingIgnoreCaseOrderByLikes(title_search);
			}
		} else {
			if (order_by.equals("dislikes")) {
				switch (top) {
				case 5:
					movie = movieRepository.findTop5ByTitleContainingIgnoreCaseOrderByDislikes(title_search);
					break;
				case 10:
					movie = movieRepository.findTop10ByTitleContainingIgnoreCaseOrderByDislikes(title_search);
					break;
				case 20:
					movie = movieRepository.findTop20ByTitleContainingIgnoreCaseOrderByDislikes(title_search);
					break;
				default:
					movie = movieRepository.findTopByTitleContainingIgnoreCaseOrderByDislikes(title_search);
				}
			} else {
				if (order_by.equals("none")) {
					switch (top) {
					case 5:
						movie = movieRepository.findTop5ByTitleContainingIgnoreCase(title_search);
						break;
					case 10:
						movie = movieRepository.findTop10ByTitleContainingIgnoreCase(title_search);
						break;
					case 20:
						movie = movieRepository.findTop20ByTitleContainingIgnoreCase(title_search);
						break;
					default:
						movie = movieRepository.findTopByTitleContainingIgnoreCase(title_search);
					}
				} else {
					Map<String, String> responseMessage = new HashMap<String, String>();
					responseMessage.put("erroCode", HttpStatus.BAD_REQUEST.toString());
					responseMessage.put("Message",
							"Wrong order_by parameter informed. Please inform likes, dislikes or none. Anything else will trhow an error.");
					return new ResponseEntity<String>(new Gson().toJson(responseMessage), HttpStatus.BAD_REQUEST);
				}
			}
		}

		return new ResponseEntity<String>(new Gson().toJson(movie), HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public Iterable<MovieEntity> getAll() {
		return movieRepository.findAll();
	}
}
