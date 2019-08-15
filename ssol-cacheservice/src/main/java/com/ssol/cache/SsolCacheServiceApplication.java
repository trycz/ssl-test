package com.ssol.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SsolCacheServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsolCacheServiceApplication.class, args);
	}

}
