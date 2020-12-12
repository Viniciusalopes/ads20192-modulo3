/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import adapter.ADListaPorArquivo;
import adapter.ADListaPorEnumerador;
import adapter.ADListaPorString;
import interfaces.IListas;

/**
 *
 * @author vovomint
 */
public class Listas implements IListas {

    private IListas listaEnum = new ADListaPorEnumerador();
    private IListas listaArquivo = new ADListaPorArquivo();
    private IListas listaString = new ADListaPorString();
    private IListas lista;

    @Override
    public Object[] getItensOrdenacao() {
        lista = listaEnum;
        lista = listaArquivo;
        lista = listaString;

        return lista.getItensOrdenacao();
    }

}
