package p4.FilaEncadeada;

import java.util.Scanner;

public class Fila {
  private static class Celula {
    int item;
    Celula prox;
  }

  private Celula frente;
  private Celula tras;
  private int tam = 0;

  // Operacoes
  public Fila() { // Cria uma Fila vazia
    frente = new Celula();
    tras = frente;
    frente.prox = null;
  }

  public void enfileira(int x) {
    tras.prox = new Celula();
    tras = tras.prox;
    tras.item = x;
    tras.prox = null;
    tam++;
  }

  public int desenfileira() {
    int valor = 0;
    if (frente != tras) {
      frente = frente.prox;
      valor = frente.item;
      tam--;
    } else
      System.out.print("Erro: A fila esta vazia");

    return valor;
  }

  public boolean vazia() {
    return (frente == tras);
  }

  public void imprime() {
    Celula aux;
    aux = frente.prox;
    while (aux != null) {
      System.out.print(" " + aux.item);
      aux = aux.prox;
    }
    System.out.println();
  }

  public Fila copiarFila() {
    Fila fila = new Fila();
    Celula curr = this.frente;
    do {
      fila.enfileira(curr.item);
      curr = curr.prox;
    } while (curr != null);
    return fila;
  }

  public int tamanho() {
    return tam;
  }

  public void verificarFila(int item, Fila fila2) {
    if (fila2.tamanho() > this.tamanho())
      fila2.enfileira(item);
    else
      this.enfileira(item);

  }
}
