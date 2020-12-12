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

public class TNome extends TMPersist {

    public TNome(String arquivo) {
        super(arquivo);
    }

    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        return aluno1.getNomeSemAcentos().compareToIgnoreCase(aluno2.getNomeSemAcentos()) <= 0;
    }
}
