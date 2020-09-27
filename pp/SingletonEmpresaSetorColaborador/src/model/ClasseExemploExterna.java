/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 27/09/2020 01:54:03 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - DECORATOR
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  
 *  -----------------------------------------------------------------------------------------------| 
 */

package model;

/**
 *
 * @author vovostudio
 */
public class ClasseExemploExterna {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    private void vai(){
        
        ClasseExemplo ce = new ClasseExemplo();
        
        int x = ce.atributoPublico;
        int y = ce.getAtributoPrivado();
        int z = ClasseExemplo.atributoEstatico;
        
        ce.atributoPublico = 2;
        
        ClasseExemplo.atributoEstatico = 7;
        
        ce.setAtributoPrivado(78);
        
        
        
    }
    
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    
    //--- GET ------------------------------------------------------------------------------------->
    //

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
