/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 11/10/2020 12:00:03 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE / FACTORY
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Propósito do arquivo.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.generic;

/**
 *
 * @author vovostudio
 */
public abstract class Factory {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    public static String domain = "br.com.vinicius.";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public static Class getClassFromPackage(String packageName, String className) throws Exception {
        return Class.forName(domain + packageName + "." + className);
    }

    public static Class getBll(String className) throws Exception {
        return getClassFromPackage("bll", "Bll" + className);
    }

    public static Object getNewInstance(Class classe) throws Exception {
        return classe.getConstructor().newInstance();
    }

    public static Object getDal(String className) throws Exception {
        return getNewInstance(getClassFromPackage("dal", "Dal" + className));
    }

    public static int getId(Object object, String methodName) throws Exception {
        return (int) object.getClass().getMethod(methodName).invoke(object);
    }

    public static Object invoke(Object object, String methodName) throws Exception {
        return object.getClass().getMethod(methodName).invoke(object);
    }

    public static Object invoke(Object object, String methodName, Class argClass, Object arg) throws Exception {
        return object.getClass().getMethod(methodName, argClass).invoke(object, arg);
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
