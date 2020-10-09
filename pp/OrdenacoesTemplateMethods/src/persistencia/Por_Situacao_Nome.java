package persistencia;

import classededados.Aluno;

public class Por_Situacao_Nome extends AlunoPersistenciaTemplateMethod {

    public Por_Situacao_Nome() {
        super();
    }

    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        return aluno1.getSituacao().equalsIgnoreCase(aluno2.getSituacao())
                && aluno1.getNomeSa().compareToIgnoreCase(aluno2.getNomeSa()) <= 0;
    }
}
