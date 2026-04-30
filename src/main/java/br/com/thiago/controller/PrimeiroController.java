package br.com.thiago.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiroController")
public class PrimeiroController {

    @GetMapping("/primeiroMetodo")
    public String primeiroMetodo() {
        return "Parabéns! Você acessou sua primeira rota com Spring Boot!";
    }
}
