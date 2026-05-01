package br.com.thiago.iocDi.semInjecao;

/*
 * Exemplo de acoplamento forte — a maneira ERRADA de gerenciar dependências.
 *
 * Problemas desta abordagem:
 *   1. CalculadoraService é responsável por criar sua própria dependência (violação do SRP).
 *   2. Impossível trocar a implementação de Calculadora sem alterar este código.
 *   3. Dificulta testes unitários, pois não é possível injetar um mock de Calculadora.
 *   4. O Spring não tem controle sobre o ciclo de vida do objeto Calculadora criado aqui.
 */
public class CalculadoraService {

    // "new" cria um objeto diretamente — CalculadoraService conhece e depende
    // da implementação concreta, não de uma abstração (interface).
    private Calculadora calculadora = new Calculadora();

    public int executar(int a, int b) {
        return calculadora.somar(a, b);
    }
}
