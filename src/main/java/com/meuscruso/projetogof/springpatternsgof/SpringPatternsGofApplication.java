package com.meuscruso.projetogof.springpatternsgof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringPatternsGofApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPatternsGofApplication.class, args);
	}

}
