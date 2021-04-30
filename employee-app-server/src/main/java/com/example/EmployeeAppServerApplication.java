package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.controller.AuthInterceptor;

@SpringBootApplication
public class EmployeeAppServerApplication extends WebMvcConfigurerAdapter {

	@Autowired
	AuthInterceptor interceptor;
	public static void main(String[] args) {
		SpringApplication.run(EmployeeAppServerApplication.class, args);
	}

	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(interceptor);
	}
	@Bean
	public CorsFilter corsFilter() {

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		final CorsConfiguration config = new CorsConfiguration();

		config.setAllowCredentials(true);

		config.addAllowedOrigin("http://localhost:4200");

		config.addAllowedHeader("Access-Control-Allow-Origin");
		config.addAllowedHeader("*");

		config.addAllowedMethod("OPTIONS");

		config.addAllowedMethod("HEAD");

		config.addAllowedMethod("GET");

		config.addAllowedMethod("PUT");

		config.addAllowedMethod("POST");

		config.addAllowedMethod("DELETE");

		config.addAllowedMethod("PATCH");

		source.registerCorsConfiguration("/**", config);

		return new CorsFilter(source);

	}
	
}
