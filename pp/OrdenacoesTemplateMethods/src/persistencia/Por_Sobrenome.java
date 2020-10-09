package persistencia;

import classededados.Aluno;

public class Por_Sobrenome extends AlunoPersistenciaTemplateMethod {

    public Por_Sobrenome(String nome) {
        super(nome);
    }

   
    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        String[] nome1 = aluno1.getNomeSa().split(" ");
        String sobrenome1 = nome1[nome1.length - 1];
        String[] nome2 = aluno2.getNomeSa().split(" ");
        String sobrenome2 = nome2[nome2.length - 1];

        if (sobrenome1.equalsIgnoreCase("junior") || sobrenome1.equalsIgnoreCase("neto") || sobrenome1.equalsIgnoreCase("filho")) {
            sobrenome1 = nome1[nome1.length - 2];
        }

        if (sobrenome2.equalsIgnoreCase("junior") || sobrenome2.equalsIgnoreCase("neto") || sobrenome2.equalsIgnoreCase("filho")) {
            sobrenome2 = nome2[nome2.length - 2];
        }

        return sobrenome1.compareToIgnoreCase(sobrenome2) <= 0;
    }
}
