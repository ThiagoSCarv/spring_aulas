package br.com.thiago.primeiro_proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
 * @SpringBootApplication é a anotação principal de uma aplicação Spring Boot.
 * Ela combina três anotações em uma só:
 *   - @Configuration: indica que esta classe pode declarar beans (objetos gerenciados pelo Spring)
 *   - @EnableAutoConfiguration: ativa a configuração automática do Spring com base nas dependências do projeto
 *   - @ComponentScan: escaneia o pacote atual em busca de componentes Spring (@Component, @Service, etc.)
 */
@SpringBootApplication

/*
 * Por padrão, @ComponentScan escaneia apenas o pacote onde a classe principal está definida
 * (br.com.thiago.primeiro_proj). Como nossas classes ficam em br.com.thiago.*,
 * expandimos o escopo para "br.com.thiago" para que o Spring encontre todos os componentes.
 */
@ComponentScan("br.com.thiago")
public class PrimeiroProjApplication {

    /*
     * Método principal da aplicação. SpringApplication.run() inicializa o contexto do Spring,
     * sobe o servidor embutido (Tomcat por padrão) e deixa a aplicação pronta para receber requisições.
     */
    public static void main(String[] args) {
        SpringApplication.run(PrimeiroProjApplication.class, args);
    }

}
