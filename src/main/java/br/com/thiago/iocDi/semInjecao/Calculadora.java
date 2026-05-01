package br.com.thiago.iocDi.semInjecao;

/*
 * Classe comum Java, sem nenhuma anotação do Spring.
 * O Spring não conhece nem gerencia esta classe — ela não faz parte do contexto de IoC.
 * Para usá-la, qualquer outra classe precisará instanciá-la manualmente com "new".
 */
public class Calculadora {

    public int somar(int a, int b) {
        return a + b;
    }
}
