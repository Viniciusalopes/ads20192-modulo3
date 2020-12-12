/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author vovomint
 */
import model.Aluno;

public class TSobrenome extends TMPersist {

    public TSobrenome(String arquivo) {
        super(arquivo);
    }

    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        String[] nome1 = aluno1.getNomeSemAcentos().split(" ");
        String sobrenome1 = nome1[nome1.length - 1];
        String[] nome2 = aluno2.getNomeSemAcentos().split(" ");
        String sobrenome2 = nome2[nome2.length - 1];

        if (sobrenome1.equalsIgnoreCase("junior")
                || sobrenome1.equalsIgnoreCase("neto")
                || sobrenome1.equalsIgnoreCase("filho")) {
            sobrenome1 = nome1[nome1.length - 2];
        }

        if (sobrenome2.equalsIgnoreCase("junior")
                || sobrenome2.equalsIgnoreCase("neto")
                || sobrenome2.equalsIgnoreCase("filho")) {
            sobrenome2 = nome2[nome2.length - 2];
        }

        return sobrenome1.compareToIgnoreCase(sobrenome2) <= 0;
    }
}
