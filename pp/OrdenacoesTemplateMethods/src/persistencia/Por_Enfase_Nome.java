package persistencia;

import classededados.Aluno;

public class Por_Enfase_Nome extends AlunoPersistenciaTemplateMethod {

    public Por_Enfase_Nome() {
        super();
    }

    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        return aluno1.getEnfase().compareToIgnoreCase(aluno2.getEnfase()) == 0
                && aluno1.getNomeSa().compareToIgnoreCase(aluno2.getNomeSa()) <= 0;
    }
}
