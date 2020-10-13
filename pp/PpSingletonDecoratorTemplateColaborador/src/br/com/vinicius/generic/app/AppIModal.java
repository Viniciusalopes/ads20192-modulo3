/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 29/09/2020 15:21:09 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Interface para expor métodos de uma JDialog para seu chamador.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.generic.app;

/**
 *
 * @author vovostudio
 */
public interface AppIModal {

    void setObject(Object object) throws Exception;

    void setFriendlyName(String friendlyName);

    void setVisible(boolean b);
}
