package persistencia;

import classededados.Aluno;

public class Por_Situacao_ extends AlunoPersistenciaTemplateMethod {

    public Por_Situacao_(String nome) {
        super(nome);
    }

    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        return aluno1.getSituacao().compareToIgnoreCase(aluno2.getSituacao()) <= 0;
    }
}
