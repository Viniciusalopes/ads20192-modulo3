package listas.ex01;

public class Lista {

    private final int MAXTAM;
    private Produtos array[];
    private int ultimo;

    public Lista(int tamanho) {
        if (tamanho <= 0) {
            throw new RuntimeException("Tamanho tem que ser maior que zero");
        }
        MAXTAM = tamanho;
        array = new Produtos[MAXTAM];
        ultimo = -1;
    }

    public boolean listaVazia() {
        return ultimo == -1;
    }

    public boolean listaCheia() {
        return ultimo + 1 == MAXTAM;
    }

    public int listaTamanho() {
        return ultimo + 1;
    }

    public void insereInicio(Produtos elemento) {
        if (listaCheia()) {
            throw new RuntimeException("Lista Cheia");
        }
        ultimo++;
        for (int i = ultimo; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = elemento;
    }

    public void insereFim(Produtos elemento) {
        if (listaCheia()) {
            throw new RuntimeException("Lista Cheia");
        }
        array[++ultimo] = elemento;
    }

    public void inserePosicao(int posicao, Produtos elemento) {
        if (listaCheia()) {
            throw new RuntimeException("Lista Cheia");
        }
        if (posicao < 0 || posicao > ultimo + 1) {
            throw new RuntimeException("Posição inválida");
        }
        ultimo++;
        for (int i = ultimo; i > posicao; i--) {
            array[i] = array[i - 1];
        }
        array[posicao] = elemento;
    }

    public void removeInicio() {
        if (listaVazia()) {
            throw new RuntimeException("Lista Vazia");
        }
        for (int i = 0; i < ultimo; i++) {
            array[i] = array[i + 1];
        }
        ultimo--;
    }

    public void removeFim() {
        if (listaVazia()) {
            throw new RuntimeException("Lista Vazia");
        }
        ultimo--;
    }

    public void removePosicao(int posicao) {
        if (listaVazia()) {
            throw new RuntimeException("Lista Vazia");
        }
        if (posicao < 0 || posicao > ultimo) {
            throw new RuntimeException("Posição inválida");
        }
        for (int i = posicao; i < ultimo; i++) {
            array[i] = array[i + 1];
        }
        ultimo--;
    }

    public boolean removeElemento(Produtos elemento) {
        int pos = buscaElemento(elemento);
        if (pos == -1) {
            return false;
        }
        removePosicao(pos);
        return true;
    }

    public int buscaElemento(Produtos elemento) {
        for (int i = 0; i <= ultimo; i++) {
            if (array[i] == elemento) {
                return i;
            }
        }
        return -1;
    }

    public Produtos getInicio() {
        if (listaVazia()) {
            throw new RuntimeException("Lista Vazia");
        }
        return array[0];
    }

    public Produtos getFim() {
        if (listaVazia()) {
            throw new RuntimeException("Lista Vazia");
        }
        return array[ultimo];
    }

    public Produtos getPosicao(int posicao) {
        if (listaVazia()) {
            throw new RuntimeException("Lista Vazia");
        }
        if (posicao < 0 || posicao > ultimo) {
            throw new RuntimeException("Posição inválida");
        }
        return array[posicao];
    }

    public void destroi() {
        ultimo = -1;
    }

    public void mostraLista() {
        if (listaVazia()) {
            System.out.println("Lista Vazia");
        } else {
            System.out.println("Elementos da lista");
            for (int i = 0; i <= ultimo; i++) {
                System.out.printf(array[i].toString());
            }
            System.out.println("");
        }
    }
}
