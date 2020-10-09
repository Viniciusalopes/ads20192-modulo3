package persistencia;

import classededados.Aluno;

public class Por_Curso_Nome extends AlunoPersistenciaTemplateMethod {

    public Por_Curso_Nome() {
        super();
    }

    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        return aluno1.getCurso().compareToIgnoreCase(aluno2.getCurso()) == 0
                && aluno1.getNomeSa().compareToIgnoreCase(aluno2.getNomeSa()) <= 0;
    }
}
