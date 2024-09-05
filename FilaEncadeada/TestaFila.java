package p4.FilaEncadeada;

public class TestaFila {

	public static void main(String[] args) {

		Fila fila = new Fila();

		// Emfileira

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

		// cria copia da fila
		Fila copia = fila.copiarFila();

		// enfileira mais um numero
		fila.enfileira(100);
		System.out.println("Enfileirou... 100 ");

		// imprime fila
		System.out.print("Imprimindo fila...");
		fila.imprime();

		// desenfileira
		while (!fila.vazia()) {
			System.out.println("Desenfileirou.." + fila.desenfileira());

			// imprime fila
			System.out.print("Imprimindo fila...");
			fila.imprime();
		}

		System.out.print("Imprimindo copia...");
		copia.imprime();

		// ERRO: fila Vazia
		fila.desenfileira();

	}
}