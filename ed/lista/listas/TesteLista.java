package listas;

public class TesteLista {

    public static void main(String[] args) {
        Lista lista = new Lista(10);
        try {
            for (int i = 0; i < 100; i++) {
                lista.inserePosicao(i, 10 - i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        lista.mostraLista();
        System.out.println("Elemento do inicio: " + lista.getInicio());
        System.out.println("Elemento do fim: " + lista.getFim());
        System.out.println(lista.buscaElemento(4));
    }
}
