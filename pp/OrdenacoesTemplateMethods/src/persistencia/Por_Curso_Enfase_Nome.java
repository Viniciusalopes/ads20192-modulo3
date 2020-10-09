package persistencia;

import classededados.Aluno;

public class Por_Curso_Enfase_Nome extends AlunoPersistenciaTemplateMethod {

    public Por_Curso_Enfase_Nome() {
        super();
    }

    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        return aluno1.getCurso().equalsIgnoreCase(aluno2.getCurso())
                && aluno1.getEnfase().equalsIgnoreCase(aluno2.getEnfase())
                && aluno1.getNome().compareToIgnoreCase(aluno2.getNome()) <= 0;
    }
}
