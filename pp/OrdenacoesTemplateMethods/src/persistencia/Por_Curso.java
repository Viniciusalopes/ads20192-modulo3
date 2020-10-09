package persistencia;

import classededados.Aluno;

public class Por_Curso extends AlunoPersistenciaTemplateMethod {

    public Por_Curso(String nome) {
        super(nome);
    }

    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        return aluno1.getCurso().compareToIgnoreCase(aluno2.getCurso()) > 0;
    }
}
