package p4.Pilha;

public class Pilha {
	private static class Celula {
		int item;
		Celula prox;
	}

	private Celula topo;
	private int tam;

	public Pilha() { // Cria uma Pilha vazia
		topo = null;
		tam = 0;
	}

	public void empilha(int x) {
		Celula aux;
		aux = topo;
		topo = new Celula();
		topo.item = x;
		topo.prox = aux;
		tam++;
	}

	public int desempilha() {
		int item = 0;
		if (topo != null) {
			item = topo.item;
			topo = topo.prox;
			tam--;
		} else
			System.out.println("ERRO: Pilha vazia!");

		return item;
	}

	public boolean vazia() {
		return (topo == null);
	}

	public int tamanho() {
		return tam;
	}
}