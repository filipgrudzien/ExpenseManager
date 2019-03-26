package com.expensetracker;

import com.expensetracker.entities.ActionStatus;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan(basePackages={"com.expensetracker"})
@EnableJpaRepositories(basePackages="com.expensetracker.repositories")
@EntityScan(basePackages="com.expensetracker.entities")
public class Application {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	ActionStatus actionStatus() {
		return new ActionStatus();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
