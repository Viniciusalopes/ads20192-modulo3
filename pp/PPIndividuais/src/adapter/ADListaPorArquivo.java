/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import interfaces.IListas;
import java.io.File;
import java.util.ArrayList;
import template.TListas;

/**
 *
 * @author vovomint
 */
public class ADListaPorArquivo extends TListas implements IListas {

    private final String root = "src/persistencia/";
    private final File dir = new File(root);

    @Override //IListas 
    public String[] getItensOrdenacao() {
        return getItensLista("arquivo");
    }

    @Override //TListas
    protected String[] getItensLista(String fonte) {
        ArrayList<String> ret = new ArrayList<>();
        for (File f : dir.listFiles()) {
            if (!f.getName().equals("TMPersist.java")) {
                ret.add(f.getName().replace(".java", "").substring(1));
            }
        }
        return (String[]) ret.toArray();
    }
}
