package persistencia;

import classededados.Aluno;

public class Por_Enfase_Curso extends AlunoPersistenciaTemplateMethod {

    public Por_Enfase_Curso() {
        super();
    }

    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        return aluno1.getEnfase().equalsIgnoreCase(aluno2.getEnfase())
                && aluno1.getCurso().compareToIgnoreCase(aluno2.getCurso()) > 0;
    }
}
