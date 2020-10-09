package persistencia;

import classededados.Aluno;

public class Por_Curso_Enfase extends AlunoPersistenciaTemplateMethod {

    public Por_Curso_Enfase() {
        super();
    }

    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        return aluno1.getCurso().equalsIgnoreCase(aluno2.getCurso())
                && aluno1.getEnfase().compareToIgnoreCase(aluno2.getEnfase()) > 0;
    }
}
