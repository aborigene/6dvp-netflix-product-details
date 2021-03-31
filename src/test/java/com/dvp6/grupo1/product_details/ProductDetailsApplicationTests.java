package com.dvp6.grupo1.product_details;

import static org.mockito.ArgumentMatchers.contains;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ProductDetailsApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	//@DisplayName("Testing \"/movie_by_genre\".")
	@Test
	void testMoviesByGenre() throws Exception {

		String genre = "action";
		String order_by = "likes";
		int top = 1;
		//DocumentContext jsonContext = JsonPath.parse(jsonDataSourceString);
		//String jsonpathCreatorName = jsonContext.read(jsonpathCreatorNamePath);
		//jsonPath("$[0].genre");
		this.mockMvc.perform(get("/api/movies_by_genre?genre="+genre+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].genre").value("action")).andExpect(jsonPath("$").isArray());
		top=5;
		this.mockMvc.perform(get("/api/movies_by_genre?genre="+genre+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].genre").value("action")).andExpect(jsonPath("$").isArray());
		top = 10;
		this.mockMvc.perform(get("/api/movies_by_genre?genre="+genre+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].genre").value("action")).andExpect(jsonPath("$").isArray());
		top = 20;
		this.mockMvc.perform(get("/api/movies_by_genre?genre="+genre+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].genre").value("action")).andExpect(jsonPath("$").isArray());
		top = 2;
		this.mockMvc.perform(get("/api/movies_by_genre?genre="+genre+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].genre").value("action")).andExpect(jsonPath("$.length()").value(1));
		

		order_by = "dislikes";
		top = 1;
		this.mockMvc.perform(get("/api/movies_by_genre?genre="+genre+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].genre").value("action")).andExpect(jsonPath("$").isArray());
		top = 5;
		this.mockMvc.perform(get("/api/movies_by_genre?genre="+genre+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].genre").value("action")).andExpect(jsonPath("$").isArray());
		top = 10;
		this.mockMvc.perform(get("/api/movies_by_genre?genre="+genre+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].genre").value("action")).andExpect(jsonPath("$").isArray());
		top = 20;
		this.mockMvc.perform(get("/api/movies_by_genre?genre="+genre+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].genre").value("action")).andExpect(jsonPath("$").isArray());
		top = 2;
		this.mockMvc.perform(get("/api/movies_by_genre?genre="+genre+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].genre").value("action")).andExpect(jsonPath("$").isArray());

		order_by = "none";
		top = 1;		
		this.mockMvc.perform(get("/api/movies_by_genre?genre="+genre+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].genre").value("action")).andExpect(jsonPath("$").isArray());
		top = 5;
		this.mockMvc.perform(get("/api/movies_by_genre?genre="+genre+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].genre").value("action")).andExpect(jsonPath("$").isArray());
		top = 10;
		this.mockMvc.perform(get("/api/movies_by_genre?genre="+genre+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].genre").value("action")).andExpect(jsonPath("$").isArray());
		top = 20;
		this.mockMvc.perform(get("/api/movies_by_genre?genre="+genre+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].genre").value("action")).andExpect(jsonPath("$").isArray());
		top = 2;
		this.mockMvc.perform(get("/api/movies_by_genre?genre="+genre+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].genre").value("action")).andExpect(jsonPath("$").isArray());
		
		
		genre = "action";
		top = 5;
		order_by = "xpto";
		this.mockMvc.perform(get("/api/movies_by_genre?genre="+genre+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isBadRequest());

	}

	@Test
	void testMovieSearch() throws Exception {

		String title_search = "u";
		String order_by = "likes";
		int top = 1;
		//DocumentContext jsonContext = JsonPath.parse(jsonDataSourceString);
		//String jsonpathCreatorName = jsonContext.read(jsonpathCreatorNamePath);
		//jsonPath("$[0].genre");

		this.mockMvc.perform(get("/api/movie_search?title_search="+title_search+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].title").isString()).andExpect(jsonPath("$.length()").value(1));
		top=5;
		this.mockMvc.perform(get("/api/movie_search?title_search="+title_search+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].title").isString()).andExpect(jsonPath("$.length()").value(5));
		top = 10;
		this.mockMvc.perform(get("/api/movie_search?title_search="+title_search+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].title").isString()).andExpect(jsonPath("$.length()").value(10));
		top = 20;
		this.mockMvc.perform(get("/api/movie_search?title_search="+title_search+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].title").isString()).andExpect(jsonPath("$.length()").value(20));
		top = 2;
		this.mockMvc.perform(get("/api/movie_search?title_search="+title_search+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].title").isString()).andExpect(jsonPath("$.length()").value(1));
		

		order_by = "dislikes";
		top = 1;
		this.mockMvc.perform(get("/api/movie_search?title_search="+title_search+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].title").isString()).andExpect(jsonPath("$.length()").value(1));
		top = 5;
		this.mockMvc.perform(get("/api/movie_search?title_search="+title_search+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].title").isString()).andExpect(jsonPath("$.length()").value(5));
		top = 10;
		this.mockMvc.perform(get("/api/movie_search?title_search="+title_search+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].title").isString()).andExpect(jsonPath("$.length()").value(10));
		top = 20;
		this.mockMvc.perform(get("/api/movie_search?title_search="+title_search+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].title").isString()).andExpect(jsonPath("$.length()").value(20));
		top = 2;
		this.mockMvc.perform(get("/api/movie_search?title_search="+title_search+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].title").isString()).andExpect(jsonPath("$.length()").value(1));

		order_by = "none";
		top = 1;		
		this.mockMvc.perform(get("/api/movie_search?title_search="+title_search+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].title").isString()).andExpect(jsonPath("$.length()").value(1));
		top = 5;
		this.mockMvc.perform(get("/api/movie_search?title_search="+title_search+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].title").isString()).andExpect(jsonPath("$.length()").value(5));
		top = 10;
		this.mockMvc.perform(get("/api/movie_search?title_search="+title_search+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].title").isString()).andExpect(jsonPath("$.length()").value(10));
		top = 20;
		this.mockMvc.perform(get("/api/movie_search?title_search="+title_search+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].title").isString()).andExpect(jsonPath("$.length()").value(20));
		top = 2;
		this.mockMvc.perform(get("/api/movie_search?title_search="+title_search+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].title").isString()).andExpect(jsonPath("$.length()").value(1));
		
		
		top = 5;
		order_by = "xpto";
		this.mockMvc.perform(get("/api/movie_search?title_search="+title_search+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isBadRequest());

		title_search = "xptoooo";
		top = 5;
		order_by = "none";
		this.mockMvc.perform(get("/api/movie_search?title_search="+title_search+"&top="+top+"&order_by="+order_by)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.length()").value(0));

	}

}
