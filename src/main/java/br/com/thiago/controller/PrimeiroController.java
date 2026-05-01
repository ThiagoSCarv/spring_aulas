package br.com.thiago.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/primeiroController")
public class PrimeiroController {

    @GetMapping("/{id}")
    public String recuperarId(@PathVariable Long id) {
        return "ID recebido: " + id;
    }

    @GetMapping("/buscar")
    public String recuperarQueryParam(@RequestParam String nome) {
        return "Query param recebido - nome: " + nome;
    }

    @GetMapping("/filtros")
    public String recuperarTodosQueryParams(@RequestParam Map<String, String> params) {
        return "Query params recebidos: " + params;
    }
}
