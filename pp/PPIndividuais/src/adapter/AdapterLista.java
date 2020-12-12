/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import interfaces.IListas;

/**
 *
 * @author vovomint
 */
public class AdapterLista implements IListas{
    private ADListaPorArquivo lista = null;
    
    public AdapterLista(){
        lista = new ADListaPorArquivo();
    }
    @Override
    public Object[] getItensOrdenacao() {
        return lista.itensDoCombobox("src/persistencia/").toArray();
    }
    
}
