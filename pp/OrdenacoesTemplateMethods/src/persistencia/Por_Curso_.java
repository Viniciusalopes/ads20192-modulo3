package persistencia;

import classededados.Aluno;

public class Por_Curso_ extends AlunoPersistenciaTemplateMethod {

    public Por_Curso_(String nome) {
        super(nome);
    }

    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        return aluno1.getCurso().compareToIgnoreCase(aluno2.getCurso()) <= 0;
    }
}
