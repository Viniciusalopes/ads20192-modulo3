package persistencia;

import classededados.Aluno;

public class Por_Situacao_Curso extends AlunoPersistenciaTemplateMethod {

    public Por_Situacao_Curso() {
        super();
    }

    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        return aluno1.getSituacao().equalsIgnoreCase(aluno2.getSituacao())
                && aluno1.getCurso().compareToIgnoreCase(aluno2.getCurso()) > 0;
    }
}
