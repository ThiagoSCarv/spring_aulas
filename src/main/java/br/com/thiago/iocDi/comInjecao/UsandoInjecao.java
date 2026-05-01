package br.com.thiago.iocDi.comInjecao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Exemplo de Injeção de Dependência (DI — Dependency Injection) com Spring.
 *
 * DI é a implementação prática de IoC: em vez de instanciar UsandoInjecaoComponent
 * com "new", declaramos a dependência e o Spring a fornece automaticamente.
 *
 * Vantagens sobre a abordagem sem injeção (semInjecao):
 *   1. Baixo acoplamento: esta classe não sabe como UsandoInjecaoComponent é criado.
 *   2. Testabilidade: é possível injetar um mock de UsandoInjecaoComponent nos testes.
 *   3. Reutilização: o Spring compartilha a mesma instância (singleton por padrão).
 *   4. Configuração centralizada: o Spring gerencia todas as dependências da aplicação.
 */
@RestController
@RequestMapping("/component")
public class UsandoInjecao {

    /*
     * @Autowired instrui o Spring a injetar automaticamente um bean do tipo
     * UsandoInjecaoComponent neste campo quando a classe for instanciada.
     * O Spring procura no seu contexto um @Component compatível e o fornece aqui.
     */
    @Autowired
    private UsandoInjecaoComponent calculadora;

    @GetMapping
    public String component() {
        return calculadora.getMensagem();
    }
}
