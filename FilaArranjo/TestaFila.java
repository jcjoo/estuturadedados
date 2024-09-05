package p4.FilaArranjo;

public class TestaFila {

	public static void main(String[] args) {

		// Construtor da fila com arranjo de 1000
		Fila fila = new Fila();

		// Enfileira

		fila.enfileira(10);
		System.out.println("Enfileirou...10 ");
		fila.enfileira(20);
		System.out.println("Enfileirou...20 ");
		fila.enfileira(30);
		System.out.println("Enfileirou...30 ");
		fila.enfileira(40);
		System.out.println("Enfileirou...40 ");

		// imprime fila
		System.out.print("Imprimindo fila...");
		fila.imprime();
		System.out.println("");

		// enfileira mais um numero
		fila.enfileira(100);
		System.out.println("Enfileirou... 100 ");

		// imprime fila
		System.out.print("Imprimindo fila...");
		fila.imprime();

		System.out.println("");

		// desenfileira
		while (!fila.vazia()) {
			System.out.println("Desenfileirou.." + fila.desenfileira());

			// imprime fila
			System.out.print("Imprimindo fila...");
			fila.imprime();
			System.out.println("");
		}

		// ERRO: fila Vazia
		fila.desenfileira();

	}
}