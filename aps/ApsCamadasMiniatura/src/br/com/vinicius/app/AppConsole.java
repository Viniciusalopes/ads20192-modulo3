/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 29/09/2020 11:01:47 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.app;

import br.com.vinicius.dal.DalTema;
import br.com.vinicius.model.Tema;
import java.util.ArrayList;

/**
 *
 * @author vovostudio
 */
public class AppConsole {

    public static void main(String[] args) {
        testTema();
    }

    private static void testTema() {
        try {
            Tema tema;
            ArrayList<Tema> temas;

            DalTema dal = new DalTema();
            tema = new Tema(0, "Tema " + Math.random());
            dal.add(tema);
            System.out.println(tema.getTema_nome() + " incluído.");

            tema = new Tema(0, "Tema " + Math.random());
            dal.add(tema);
            System.out.println(tema.getTema_nome() + " incluído.");

            tema = new Tema(0, "Tema " + Math.random());
            dal.add(tema);
            System.out.println(tema.getTema_nome() + " incluído.");

            System.out.println("-- FIM CREATE --");

            temas = (ArrayList<Tema>) dal.getAll();
            imprimirTemas(temas);
            
            System.out.println("-- FIM READ--");
            dal.delete(temas.get(2).getTema_id());
            temas = (ArrayList<Tema>) dal.getAll();
            imprimirTemas(temas);
            System.out.println("-- FIM READ --");

            tema = temas.get(0);
            dal = new DalTema();
            tema = dal.getById(tema.getTema_id());
            tema.setTema_nome("Tema B");
            dal.update(tema);
            temas = (ArrayList<Tema>) dal.getAll();
            imprimirTemas(temas);

            System.out.println("-- FIM UPDATE --");

            dal.delete(tema.getTema_id());
            temas = (ArrayList<Tema>) dal.getAll();
            for (Tema t : temas) {
                dal.delete(t.getTema_id());
            }
            temas = (ArrayList<Tema>) dal.getAll();
            imprimirTemas(temas);
            System.out.println("-- FIM DELETE --");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void imprimirTemas(ArrayList<Tema> temas) throws Exception {
        System.out.println("\n TEMAS: ");
        for (Tema tema : temas) {
            System.out.println(tema.getTema_id() + " - " + tema.getTema_nome());
        }
    }
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