package persistencia;

import classededados.Aluno;

public class Por_Enfase_ extends AlunoPersistenciaTemplateMethod {

    public Por_Enfase_(String nome) {
        super(nome);
    }

    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        return aluno1.getEnfase().compareToIgnoreCase(aluno2.getEnfase()) <= 0;
    }
}
