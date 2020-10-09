package persistencia;

import classededados.Aluno;

public class Por_Nome extends AlunoPersistenciaTemplateMethod {

    public Por_Nome(String nome) {
        super(nome);
    }
    @Override
    public  boolean ePrimeiro(Aluno aluno1, Aluno aluno2){
        return aluno1.getNomeSa().compareToIgnoreCase(aluno2.getNomeSa()) <= 0;
    }
}
