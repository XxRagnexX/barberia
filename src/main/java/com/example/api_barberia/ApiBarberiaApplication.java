package com.example.api_barberia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * esto es lo principal de la app, el main que arranca todo
 * cuando lo ejecutas se prende el servidor en http://localhost:8080
 * (yo lo corro desde IntelliJ le doy a run y listo)
 */
@SpringBootApplication
public class ApiBarberiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBarberiaApplication.class, args);
	}

}
