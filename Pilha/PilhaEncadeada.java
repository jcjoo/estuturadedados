package p4.Pilha;

import java.util.Scanner;

public class PilhaEncadeada {
    // Exibe o menu de opções para o usuário
    public static class Acao {
        public enum TipoAcao {
            COPIAR, EXCLUIR, RECORTAR, ALTERAR
        };

        private TipoAcao tipo;
        private String conteudo;

        public Acao(TipoAcao tipo, String conteudo) {
            this.tipo = tipo;
            this.conteudo = conteudo;
        }

        public TipoAcao getAcao() {
            return this.tipo;
        }

        public String getConteudo() {
            return this.conteudo;
        }
    }

    public static class Pilha {
        private class Node {
            Acao acao;
            Node proximo;

            Node(Acao acao) {
                this.acao = acao;
                this.proximo = null;
            }

        }

        private Node topo;
        private int tam = 0;

        public Pilha() {
            this.topo = null;
        }

        public void empilhar(Acao acao) {
            Node aux = this.topo;
            this.topo = new Node(acao);
            topo.proximo = aux;
            tam++;
        }

        public Acao desempilhar() {
            Acao aux = null;
            if (topo != null) {
                aux = topo.acao;
                topo = topo.proximo;
                tam--;
            }

            return aux;
        }

        public boolean vazia() {
            return (topo == null);
        }

        public int tamanho() {
            return tam;
        }

    }

    public static class Editor {
        private Pilha pilhaAcoes = new Pilha();
        private Pilha pilhaDesfazer = new Pilha();
        private Pilha pilhaRefazer = new Pilha();

        private void menu() {
            System.out.println("Escolha uma ação:");
            System.out.println("1 - Copiar");
            System.out.println("2 - Excluir");
            System.out.println("3 - Recortar");
            System.out.println("4 - Alterar Formatação");
            System.out.println("5 - Desfazer");
            System.out.println("6 - Refazer");
            System.out.println("7 - Sair");
        }

        private void copiar() {
            pilhaAcoes.empilhar(new Acao(Acao.TipoAcao.COPIAR, "copiado"));
            System.out.println("Tamanho: " + pilhaAcoes.tam + " Conteudo topo: " + pilhaAcoes.topo.acao.conteudo);
        }

        private void excluir() {
            pilhaAcoes.empilhar(new Acao(Acao.TipoAcao.EXCLUIR, "excluir"));
            System.out.println("Tamanho: " + pilhaAcoes.tam + " Conteudo topo: " + pilhaAcoes.topo.acao.conteudo);
        }

        private void recortar() {
            pilhaAcoes.empilhar(new Acao(Acao.TipoAcao.RECORTAR, "colado"));
            System.out.println("Tamanho: " + pilhaAcoes.tam + " Conteudo topo: " + pilhaAcoes.topo.acao.conteudo);
        }

        private void alterarFormatacao() {
            pilhaAcoes.empilhar(new Acao(Acao.TipoAcao.ALTERAR, "formatacao alterada"));
            System.out.println("Tamanho: " + pilhaAcoes.tam + " Conteudo topo: " + pilhaAcoes.topo.acao.conteudo);
        }

        private void desfazer() {

            Acao acao = pilhaAcoes.desempilhar();
            pilhaDesfazer.desempilhar();
            pilhaRefazer.empilhar(acao);
            System.out.println("Tamanho: " + pilhaAcoes.tam + " Conteudo topo: " + pilhaAcoes.topo.acao.conteudo);

        }

        private void refazer() {
            if (pilhaRefazer.vazia()) {
                System.out.println("Tamanho: " + pilhaAcoes.tam);
                return;
            }
            Acao acao = pilhaRefazer.desempilhar();
            pilhaAcoes.empilhar(acao);
            pilhaDesfazer.empilhar(acao);
            System.out.println("Tamanho: " + pilhaAcoes.tam + " Conteudo topo: " + pilhaAcoes.topo.acao.conteudo);

        }

        public void start() {
            Scanner sc = new Scanner(System.in);
            this.menu();
            int option;
            do {
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        this.copiar();
                        break;

                    case 2:
                        this.excluir();
                        break;

                    case 3:
                        this.recortar();
                        break;
                    case 4:
                        this.alterarFormatacao();
                        break;
                    case 5:
                        this.desfazer();
                        break;
                    case 6:
                        this.refazer();
                        break;
                    default:
                        break;
                }

            } while (option != 7);
            sc.close();
        }
    }

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.start();
    }
}