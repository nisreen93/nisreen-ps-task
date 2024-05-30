package com.demo.FXDealsAnalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.demo")
@EnableJpaRepositories(basePackages = "com.demo.dao")
@EntityScan(basePackages = "com.demo.model")
public class FxDealsAnalyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FxDealsAnalyzerApplication.class, args);
	}

}
