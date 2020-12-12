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
public class ADListaPorArquivo {

    private String root = "src/persistencia/";
    private File dir;

    public ArrayList<String> itensDoCombobox(String root) {
        if (root.trim().length() > 0) {
            this.root = root;
        }
        dir = new File(root);
        return retornarNomesDeClasses();
    }

    protected ArrayList<String> retornarNomesDeClasses() {
        ArrayList<String> ret = new ArrayList<>();
        for (File f : dir.listFiles()) {
            if (!f.getName().equals("TMPersist.java")) {
                ret.add(f.getName().replace(".java", "").substring(1));
            }
        }
        return ret;
    }
}
