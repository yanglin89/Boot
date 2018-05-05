package com.run.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.run.boot.config.AuthorSettings;
import com.run.spring_boot_starter_hello.HelloService;


@RestController
@SpringBootApplication
//建议DemoApplication类放置在groupID+arctifactId组合的包名下（一般是最根的包下）,此项目中为com.run.boot
public class BootApplication {

	
	@Value("${book.author}")
	private String bookAuthor;
	@Value("${book.name}")
	private String bookName;
	
	@Autowired
	private AuthorSettings authorSettings;
	
	@Autowired
	private HelloService HelloService;
	
	@RequestMapping("/")
	String index() {
//		return "author name is : "+ authorSettings.getName() + " and author age is :"+ authorSettings.getAge();
		return HelloService.sayHello();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}
}
