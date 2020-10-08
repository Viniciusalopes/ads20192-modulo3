/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 29/09/2020 20:51:52 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  
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
    //--- GET ------------------------------------------------------------------------------------->
    //
    public static Object getObjectByid(int idObject, String className) throws Exception {
        return invoke(getDal(className), "getById", int.class, idObject);
    }

    public static Class getClassFromModel(String className) throws Exception {
        return Class.forName(domain + "model." + className);
    }

    public static Class getClassFromPackage(String packageName, String className) throws Exception {
        return Class.forName(domain + packageName + "." + className);
    }

    public static Object getDal(String className) throws Exception {
        return getNewInstance(getClassFromPackage("dal", "Dal" + className));
    }

    public static Object getBll(String className) throws Exception {
        return getNewInstance(getClassFromPackage("bll", "Bll" + className));
    }

    public static Object getNewInstance(Class classe) throws Exception {
        return classe.getConstructor().newInstance();
    }

    public static int getId(Object object) throws Exception {
        return (int) object.getClass()
                .getMethod("get" + object.getClass().getSimpleName() + "_id")
                .invoke(object);
    }

    public static Object invoke(Object object, String methodName) throws Exception {
        return object.getClass().getMethod(methodName).invoke(object);
    }

    public static Object invoke(Object object, String methodName, Class classe, Object arg) throws Exception {
        return object.getClass().getMethod(methodName, classe).invoke(object, arg);
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
}
