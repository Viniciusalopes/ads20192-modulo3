/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 03/10/2020 15:00:16 
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
package fabrica;

import classededados.Aluno;

/**
 *
 * @author vovostudio
 */
public class FabricaAluno extends Fabrica {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public static String getValorAtributo(Aluno aluno, String atributo) throws Exception {
        return Fabrica.getAttributeValue(aluno, atributo);
    }

    public static String getSobrenome(String nome) {
        String invalidos = "junior júnior neto filho";
        String[] partes = nome.split(" ");
        String ret = "";
        int i = partes.length - 1;
        while (i > 0) {
            if (!invalidos.contains(partes[i])) {
                ret = partes[i].toUpperCase() + ", " + partes[0];
            }
            i--;
        }
        return ret;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}