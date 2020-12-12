/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import interfaces.IListas;
import template.TListas;

/**
 *
 * @author vovomint
 */
public class ADListaPorEnumerador extends TListas implements IListas{

    @Override
    public Object[] getItensOrdenacao() {
        return getItensLista("enum");
    }

   
    @Override //TListas
    protected String[] getItensLista(String fonte) {
        if (fonte.equals("enum")) {
            return super.getItensEnum();
        } else {
            return super.itensString;
        }
    }

}
