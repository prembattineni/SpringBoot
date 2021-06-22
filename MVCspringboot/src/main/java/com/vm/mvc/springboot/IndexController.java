package com.vm.mvc.springboot;



import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {

	
	@RequestMapping("/books/{name}/{course}")  //in url after 8081/books/we give number it prints/we give number it prints
	public String hello(@PathVariable("name") String name,@PathVariable("course") String course )
	{
		return "hello world\t" + name+"\t"+course;
	}
}
