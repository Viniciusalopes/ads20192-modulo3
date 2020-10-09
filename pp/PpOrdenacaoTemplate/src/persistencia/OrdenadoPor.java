/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 02/10/2020 18:59:02 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - TEMPLATE METHOD
 *  Exercício  : Métodos de ordenação
 *  ------------------------------------------------------------------------------------------------
 *  
 *  -----------------------------------------------------------------------------------------------| 
 */
package persistencia;

import fabrica.Fabrica;

/**
 *
 * @author vovostudio
 */
public class OrdenadoPor extends Persistencia {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private String[] orderBy;
    private Object object;
    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public OrdenadoPor(String fileName, String[] orderBy, Class objectClass) throws Exception {
        super(fileName);
        this.orderBy = orderBy;
    }

      //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    @Override
    public boolean ePrimeiro(Object obj1, Object obj2) throws Exception {

        int[] values = new int[orderBy.length];
        String atributoA = "";
        String valueB = "";

        for (int i = 0; i < orderBy.length; i++) {
            
            values[i] = get(obj1, orderBy[i]).compareToIgnoreCase(get(obj2, orderBy[i]));
        }

        switch (orderBy.length) {
            case 3:
                return values[0] == 0 && values[1] == 0 && values[2] <= 0;

            case 2:
                return values[0] == 0 && values[1] <= 0;

            default:
                return values[0] <= 0;
        }
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
}
