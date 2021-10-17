package com.cakefactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CakeFactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CakeFactoryApplication.class, args);
	}
    
    @Bean
    public CatalogService catalogService() {
        return new InMemoryCatalog();
    }
}