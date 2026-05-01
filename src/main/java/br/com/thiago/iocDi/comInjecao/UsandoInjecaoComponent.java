package br.com.thiago.iocDi.comInjecao;

import org.springframework.stereotype.Component;

/*
 * @Component registra esta classe no contexto de IoC (Inversão de Controle) do Spring.
 * A partir daí, o Spring passa a gerenciar o ciclo de vida deste objeto:
 * ele cria, configura e destrói a instância conforme necessário.
 *
 * Outras anotações como @Service, @Repository e @Controller são especializações
 * de @Component com semântica mais específica para cada camada da aplicação.
 *
 * IoC (Inversion of Control): em vez de a classe criar suas dependências,
 * ela delega essa responsabilidade ao framework (Spring).
 */
@Component
public class UsandoInjecaoComponent {

    public String getMensagem() {
        return "Componente montado! O Spring está responsável por essa dependência.";
    }
}
