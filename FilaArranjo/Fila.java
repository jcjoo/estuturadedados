package p4.FilaArranjo;

public class Fila {
  private int item[];
  private int frente, tras, tamanho;

  // Cria uma Fila vazia
  public Fila() {
    item = new int[1000];
    frente = 0;
    tras = this.frente;
    tamanho = 0;
  }

  // Cria uma fila vazia passando tamanho do arranjo
  public Fila(int maxTam) {
    item = new int[maxTam];
    frente = 0;
    tras = this.frente;
    tamanho = 0;
  }

  // Enfileira um elmento na fila
  public void enfileira(int x) {
    if ((tras + 1) % item.length != frente) {
      item[tras] = x;
      tras = (tras + 1) % item.length;
      tamanho++;
    }

    else
      System.out.println("ERRO: Fila cheia!");
  }

  // Desenfileira um elemento na fila
  public int desenfileira() {
    int valor = 0;
    if (frente != tras) {
      valor = item[frente];
      frente = (frente + 1) % item.length;
      tamanho--;
    } else
      System.out.println("ERRO: Fila vazia!");

    return valor;
  }

  // Verifica Fila vazia
  public boolean vazia() {
    return (tamanho == 0);
  }

  // Imprime Fila
  public void imprime() {
    for (int i = frente; i != tras; i = (i + 1) % item.length)
      System.out.print(item[i] + " ");
  }
}
