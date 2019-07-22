package com.skillsmap.role.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class RoleApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RoleApplication.class);
	}
	
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = 
		SpringApplication.run(RoleApplication.class, args);
	}
	
	@Controller
	class WebController {
		
		@GetMapping
		public String home(){
			return "index";
		}
	}
	
	

}
