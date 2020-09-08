import java.io.BufferedReader;
import java.io.FileReader;
public class TesteExercicio {

    public static void main(String[] args) {
        //String arquivo = "C:\\Joseluiz\\2014_1\\Senai\\LPMP\\Aulas\\Aula13_25032014\\Exercicio_Produto\\src\\produto.csv";
        //String arquivo ="/Users/FAPEG_JOSELUIZ/Documents/joseluiz_22072014/2014_1/Senai/LPMP/Aulas/Aula13_25032014/Exercicio_Produto/src/produto.csv";
        String arquivo = "./src/produto.csv";
        Produto p[] = new Produto[20];
        lerDados(p, arquivo); 
        imprimir(p);
        System.out.println("==============================");
        insercaoString(p);
        imprimir(p);
    }

    public static void lerDados(Produto lista[], String arq) {

        try {

            FileReader fr = new FileReader(arq);
            BufferedReader br = new BufferedReader(fr);
            String linha;
            int i=0;
            while ((linha = br.readLine()) != null) {
                String[] dados;
                dados = linha.split(";");
                Produto objetoProduto = new Produto();
                objetoProduto.setCodigo(Integer.parseInt(dados[0]));
                objetoProduto.setDescricao(dados[1]);
                objetoProduto.setPreco(Float.parseFloat(dados[2]));
                lista[i]=objetoProduto;
                i++;
            }
           
        } catch (Exception erro) {
            System.out.println("Erro ao abrir o arquivo.");
        }

    }

    //ordena pelo método da inserção direta
    public static void insercao(Produto vet[]) {
        int i;
        Produto aux;
        for (int j = 1; j < vet.length; j++) {
            aux = vet[j];
            i = j - 1;
            while (i >= 0 && vet[i].getPreco() > aux.getPreco()) {
                vet[i + 1] = vet[i];
                i--;
            }
            vet[i + 1] = aux;
        }
    }
    //ordena pelo método da inserção direta
    public static void insercaoString(Produto vet[]) {
        int i;
        Produto aux;
        for (int j = 1; j < vet.length; j++) {
            aux = vet[j];
            i = j - 1;
            while (i >= 0 && vet[i].getDescricao().compareToIgnoreCase(aux.getDescricao()) > 0) {
                vet[i + 1] = vet[i];
                i--;
            }
            vet[i + 1] = aux;
        }
    }
    
    public static void imprimir(Produto p[]) {
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);
        }
    }
}
