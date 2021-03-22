package com.dvp6.grupo1.product_details;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductDetailsController { 
    @RequestMapping(method = RequestMethod.GET, value = "/api/movies_by_genre")
    @ResponseBody
	public String moviesByGenre(@RequestParam(name = "order_by") String orderBy, @RequestParam(name = "top") int top) {
		return "order: "+orderBy+", top: "+top;
	}    
}
