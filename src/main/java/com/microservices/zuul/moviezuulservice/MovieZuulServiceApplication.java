package com.microservices.zuul.moviezuulservice;

import com.microservices.zuul.moviezuulservice.filter.ErrorFilter;
import com.microservices.zuul.moviezuulservice.filter.PostFilter;
import com.microservices.zuul.moviezuulservice.filter.PreFilter;
import com.microservices.zuul.moviezuulservice.filter.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
/*import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer*/;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
@EnableDiscoveryClient
//@EnableOAuth2Client
@EnableZuulProxy
public class MovieZuulServiceApplication {
	@Bean
	public ErrorFilter getErrorFilter(){
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter getRouteFilter(){
		return new RouteFilter();
	}

	@Bean
	public PreFilter getPreFilter(){
		return new PreFilter();
	}

	@Bean
	public PostFilter getPostFilter(){
		return new PostFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieZuulServiceApplication.class, args);
	}

/*
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}*/



}
