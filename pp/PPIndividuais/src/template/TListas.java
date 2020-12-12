/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package template;

import enums.EItens;
import java.util.ArrayList;

/**
 *
 * @author vovomint
 */
public abstract class TListas {

    protected String[] itensString = new String[]{
        "Curso_Enfase_Nome",
        "Curso_Nome",
        "Enfase_Curso_Nome",
        "Enfase_Nome",
        "Nome",
        "Situacao_Curso_nome",
        "Situacao_Nome",
        "Sobrenome"
    };

    protected String[] getItensEnum() {
        ArrayList<String> ret = new ArrayList<>();

        for (EItens v : EItens.values()) {
            ret.add(v.toString().substring(1));
        }
        return (String[]) ret.toArray();
    }

    protected abstract String[] getItensLista(String fonte);

}
