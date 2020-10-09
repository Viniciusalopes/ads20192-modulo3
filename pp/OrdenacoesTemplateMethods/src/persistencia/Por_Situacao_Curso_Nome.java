package persistencia;

import classededados.Aluno;

public class Por_Situacao_Curso_Nome extends AlunoPersistenciaTemplateMethod {

    public Por_Situacao_Curso_Nome() {
        super();
    }

    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        return aluno1.getSituacao().equalsIgnoreCase(aluno2.getSituacao())
                && aluno1.getCurso().equalsIgnoreCase(aluno2.getCurso())
                && aluno1.getNome().compareToIgnoreCase(aluno2.getNome()) <= 0;
    }
}
