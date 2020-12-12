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

public class TSituacao_Curso_Nome extends TMPersist {

    public TSituacao_Curso_Nome(String arquivo) {
        super(arquivo);
    }

    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        if (aluno1.getSituacao().equalsIgnoreCase(aluno2.getSituacao())) {
            if (aluno1.getCurso().equalsIgnoreCase(aluno2.getCurso())) {
                return aluno1.getNomeSemAcentos().compareToIgnoreCase(aluno2.getNomeSemAcentos()) <= 0;
            } else {
                return aluno1.getCurso().compareToIgnoreCase(aluno2.getCurso()) <= 0;
            }
        } else {
            return aluno1.getSituacao().compareToIgnoreCase(aluno2.getSituacao()) <= 0;
        }
    }
}