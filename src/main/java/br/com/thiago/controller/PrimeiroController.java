package br.com.thiago.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*
 * @RestController combina @Controller + @ResponseBody.
 * Indica que esta classe é um controlador HTTP e que todos os métodos retornam
 * dados diretamente no corpo da resposta (JSON, texto, etc.), sem renderizar views.
 *
 * @RequestMapping define o prefixo de rota para todos os métodos desta classe.
 * Todos os endpoints abaixo serão acessados em /primeiroController/...
 */
@RestController
@RequestMapping("/primeiroController")
public class PrimeiroController {

    /*
     * Record é um tipo especial do Java (desde Java 16) para criar classes de dados imutáveis.
     * O compilador gera automaticamente construtor, getters, equals, hashCode e toString.
     * Aqui é usado para mapear o corpo (body) da requisição JSON: { "username": "valor" }
     */
    record Usuario(String username) {}

    /*
     * ResponseEntity permite controlar completamente a resposta HTTP:
     * status code, headers e body. Aqui retornamos sempre 400 Bad Request.
     * Útil para demonstrar que nem sempre uma resposta precisa ser 200 OK.
     */
    @GetMapping("/badRequest")
    public ResponseEntity<String> badRequest() {
        return ResponseEntity.badRequest().body("Bad Request!");
    }

    /*
     * @RequestParam captura parâmetros de query string da URL: /validarNumero?numero=3
     * ResponseEntity.badRequest() retorna 400, ResponseEntity.ok() retorna 200.
     * Este método demonstra validação simples com retorno de status HTTP apropriado.
     */
    @GetMapping("/validarNumero")
    public ResponseEntity<String> validarNumero(@RequestParam Integer numero) {
        if (numero < 5) {
            return ResponseEntity.badRequest().body("Número deve ser maior ou igual a 5");
        }
        return ResponseEntity.ok("Número válido: " + numero);
    }

    /*
     * @PostMapping mapeia requisições HTTP POST para este método.
     * @RequestBody faz o Spring deserializar o JSON do corpo da requisição
     * para o tipo do parâmetro anotado (neste caso, o record Usuario).
     * Exemplo de body: { "username": "thiago" }
     */
    @PostMapping("/metodoComBodyParams")
    public String metodoComBodyParams(@RequestBody Usuario usuario) {
        return "Usuário recebido: " + usuario.username();
    }

    /*
     * @RequestHeader recupera um header específico da requisição HTTP pelo nome.
     * Headers são metadados enviados junto à requisição (ex: autenticação, tipo de conteúdo).
     * Exemplo: Authorization: Bearer meu-token
     */
    @PostMapping("/metodoComUmHeader")
    public String metodoComUmHeader(@RequestHeader("Authorization") String authorization) {
        return "Header recebido - Authorization: " + authorization;
    }

    /*
     * Quando @RequestHeader recebe um Map<String, String>, o Spring injeta
     * todos os headers da requisição de uma vez, sem precisar declarar cada um.
     */
    @PostMapping("/metodoComTodosHeaders")
    public String metodoComTodosHeaders(@RequestHeader Map<String, String> headers) {
        return "Headers recebidos: " + headers;
    }

    /*
     * @PathVariable captura um segmento dinâmico da URL definido entre chaves {}.
     * Exemplo: GET /primeiroController/42 → id = 42
     * O nome da variável na anotação deve bater com o nome entre chaves na rota.
     */
    @GetMapping("/{id}")
    public String recuperarId(@PathVariable Long id) {
        return "ID recebido: " + id;
    }

    /*
     * @RequestParam captura um único parâmetro de query string da URL.
     * Exemplo: GET /primeiroController/buscar?nome=thiago → nome = "thiago"
     * Por padrão o parâmetro é obrigatório; use required=false para torná-lo opcional.
     */
    @GetMapping("/buscar")
    public String recuperarQueryParam(@RequestParam String nome) {
        return "Query param recebido - nome: " + nome;
    }

    /*
     * Quando @RequestParam recebe um Map<String, String>, o Spring injeta
     * todos os query params da URL de uma vez.
     * Exemplo: GET /primeiroController/filtros?nome=thiago&idade=30
     */
    @GetMapping("/filtros")
    public String recuperarTodosQueryParams(@RequestParam Map<String, String> params) {
        return "Query params recebidos: " + params;
    }
}
