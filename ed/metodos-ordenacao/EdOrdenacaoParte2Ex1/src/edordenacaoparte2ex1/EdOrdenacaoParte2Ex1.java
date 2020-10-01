/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edordenacaoparte2ex1;

/**
 *
 * @author vovostudio
 */
public class EdOrdenacaoParte2Ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String entrada = "Toda vez que eu via JAVA pela estrada de ouro fino";

        int freq[] = new int[256];
        int ordem[] = new int[256];

        for (int i = 0; i < entrada.length(); i++) {
            freq[entrada.charAt(i)]++;
        }
        
        // Conta a quantidade de caracteres com 1 ou mais ocorrencias.
        int quantidadeDeElementosDiferentesDeZero = 0;
        
        for (int i = 0; i < freq.length; i++) {
            if(freq[i] > 0){
                quantidadeDeElementosDiferentesDeZero++;
            }
        }
        
        // Ordenação ShellSort
        int tmp;
        int qde = freq.length;

        int j;
        for (int gap = qde / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < qde; i++) {
                tmp = freq[i];
                // tmp.getNome().compareToIgnoreCase(a[j - gap].getNome())< 0); j -= gap) 
                // tmp                             < a[j - gap])              ; j -= gap) {
                for (j = i; j >= gap && (tmp < freq[j - gap]); j -= gap) {
                    freq[j] = freq[j - gap];
                }
                freq[j] = tmp;
            }
        }

    }

    private static void ordena_shellSort(int[] a) {
        int tmp;
        int qde = a.length;

        int j;
        for (int gap = qde / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < qde; i++) {
                tmp = a[i];
                // tmp.getNome().compareToIgnoreCase(a[j - gap].getNome())< 0); j -= gap) 
                // tmp                             < a[j - gap])              ; j -= gap) {
                for (j = i; j >= gap && (tmp < a[j - gap]); j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }
        }
    }

}
