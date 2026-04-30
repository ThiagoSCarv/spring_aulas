package br.com.thiago.primeiro_proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.thiago")
public class PrimeiroProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeiroProjApplication.class, args);
	}

}
