package com.omargroup.todo_backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TodoBackendApplication {


	public static void main(String[] args) {
		SpringApplication.run(TodoBackendApplication.class, args);

	}

//	@Bean
//	public WebMvcConfigurer corsConfiguirer(){
//		return new WebMvcConfigurer() {
//			public void addCordsMapping(CorsRegistry registry){
//				registry.addMapping("/**")
//						.allowedMethods("*")
//						.allowedOrigins("http://localhost:5173");
//			}
//		};
//	}


}
