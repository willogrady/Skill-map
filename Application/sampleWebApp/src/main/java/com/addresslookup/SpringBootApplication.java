package com.addresslookup;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


//@EnableJpaAuditing	//tells spring boot to start adding beans based on class path
@ComponentScan("com.addresslookup.dao")	//to automatically pick up spring components
@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication extends SpringBootServletInitializer {
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SpringBootApplication.class);
	
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootApplication.class);
    }

    public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootApplication.class, args);
        
		logger.info("This Spring Application is a go!!");
		
//		ctx.close();
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
}
	


