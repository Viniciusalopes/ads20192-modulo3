/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 29/09/2020 20:51:52 
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
package br.com.vinicius.generic;

import static br.com.vinicius.generic.AppFactory.getModal;
import static br.com.vinicius.generic.AppMensagem.mensagemEscolher;
import java.lang.reflect.Method;

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

    public static Class getBll(String className) throws Exception {
        return getClassFromPackage("bll", "Bll" + className);
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

    public static Object invoke(Object object, String methodName, Class argClass, Object arg) throws Exception {
        return object.getClass().getMethod(methodName, argClass).invoke(object, arg);
    }

    public static boolean dependenciesWhereSatisfied(String mainTable, String[] foreignKeys, String[] friendlyNames) throws Exception {

        String fk = "";
        String fn = "";

        Object dal;
        Method method;

        // Verifico se tem pelo menos um cadastro das dependências necessárias
        String pergunta = "";
        for (int i = 0; i < foreignKeys.length; i++) {
            fk = foreignKeys[i];
            fn = friendlyNames[i];

            pergunta = "Para cadastrar " + mainTable + " você precisa cadastrar um " + fn + ".\n"
                    + "O que deseja fazer?";

            dal = getDal(fk);
            method = dal.getClass().getMethod("isEmptyTable");

            if ((boolean) method.invoke(dal)) {
                if (mensagemEscolher(pergunta, new String[]{"Sair do sistema", "Incluir um " + fn}) > 0) {
                    getModal(fk, fn, "add", null, new AppSimpleForm(null, true));
                }
            }

            if ((boolean) method.invoke(dal)) {
                throw new Exception("Não é possível incluir uma " + mainTable + ".\n"
                        + "Você não incluiu nenhum " + fn + ".");
            }
        }
        return true;
    }

    public static void checkForeignKeys(Object mainObject, String[] foreignKeys, String[] friendlyNames) throws Exception {
        for (int i = 0; i < foreignKeys.length; i++) {
            String fk = foreignKeys[i];
            String fn = friendlyNames[i];

            Class bll = getBll(fk);
            Object object = mainObject.getClass().getMethod("get" + fk).invoke(mainObject);
            int id = (int) getId(object);

            // verifica se o cadastro da fk existe
            if (!(boolean) bll.getMethod("exists", int.class, String.class).invoke(object, id, fk)) {
                throw new Exception(fn + " inválido!");
            }
        }
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
}
