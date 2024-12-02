package br.com.fiap.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.fiap.cliente")
public class FoodtechClienteService {

	public static void main(String[] args) {
		SpringApplication.run(FoodtechClienteService.class, args);
	}

}
