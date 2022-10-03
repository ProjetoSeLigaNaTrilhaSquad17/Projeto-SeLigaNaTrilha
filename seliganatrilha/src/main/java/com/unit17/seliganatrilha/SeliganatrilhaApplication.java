package com.unit17.seliganatrilha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SeliganatrilhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeliganatrilhaApplication.class, args);
	}

}
