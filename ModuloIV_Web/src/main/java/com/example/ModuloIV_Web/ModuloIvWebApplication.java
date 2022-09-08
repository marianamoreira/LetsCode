package com.example.ModuloIV_Web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ModuloIvWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuloIvWebApplication.class, args);
	}

}
