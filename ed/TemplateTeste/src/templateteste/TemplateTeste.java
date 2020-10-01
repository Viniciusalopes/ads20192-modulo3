/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templateteste;

/**
 *
 * @author vovostudio
 */
public class TemplateTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pessoa[] pessoas = new Pessoa[]{
            new Pessoa("Rodrigo", "Matematica"),
            new Pessoa("Diego a", "Filosofia"),
            new Pessoa("Eustáqu", "Matematica"),
            new Pessoa("Zebedeu", "ADM"),
            new Pessoa("José Av", "Matematica"),
            new Pessoa("Marcelo", "ADM"),
            new Pessoa("Ana Mar", "Filosofia"),
            new Pessoa("Vovôlin", "Adm")
        };

        shellSort(pessoas);
        Pessoa[] cursoNome = new Pessoa[pessoas.length];
        
        cursoNome[0] = 
        for (int i = 0; i < pessoas.length; i++) {
            nomes[i] = pessoas[i];
            
        }
        
        shellSort(nomes);
        shellSort(cursos);

        pessoas = new Pessoa[nomes.length];
        for (int i = 0; i < cursos.length; i++) {
            for (int j = 0; j < nomes.length; j++) {
                 
            }
        }

    }

    private static void shellSort(String[] pessoas) {
        // Ordenação ShellSort
        String tmp;
        int qde = pessoas.length;

        int j;
        for (int gap = qde / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < qde; i++) {
                tmp = pessoas[i];
                for (j = i; j >= gap && (tmp.compareToIgnoreCase(pessoas[j - gap]) < 0); j -= gap) {
                    pessoas[j] = pessoas[j - gap];
                }
                pessoas[j] = tmp;
            }
        }
    }

    private static void shellSort(Pessoa[] pessoas) {
        // Ordenação ShellSort
        Pessoa tmp;
        int qde = pessoas.length;

        int j;
        for (int gap = qde / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < qde; i++) {
                tmp = pessoas[i];
                for (j = i; j >= gap && (tmp.getNome().compareToIgnoreCase(pessoas[j - gap].getNome()) < 0); j -= gap) {
                    pessoas[j] = pessoas[j - gap];
                }
                pessoas[j] = tmp;
            }
        }
    }
}
