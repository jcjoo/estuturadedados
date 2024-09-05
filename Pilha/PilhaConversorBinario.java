package p4.Pilha;

import java.util.Stack;

public class PilhaConversorBinario {
    public static void main(String[] args) {
        int numeroDecimal = 29; // Exemplo de número decimal

        // Chama a função de conversão
        String binario = decimalParaBinario(numeroDecimal);

        System.out.println("Número decimal: " + numeroDecimal);
        System.out.println("Número binário: " + binario);
    }

    public static String decimalParaBinario(int numero) {
        if (numero == 0) {
            return "0";
        }

        Stack<Integer> pilha = new Stack<>();

        // Empilha os restos da divisão por 2
        while (numero > 0) {
            pilha.push(numero % 2);
            numero /= 2;
        }

        // Construa a representação binária a partir dos valores na pilha
        StringBuilder binario = new StringBuilder();
        while (!pilha.isEmpty()) {
            binario.append(pilha.pop());
        }

        return binario.toString();
    }
}
