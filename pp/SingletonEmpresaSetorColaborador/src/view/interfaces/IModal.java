/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 12/09/2020 14:58:12 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  
 *  ------------------------------------------------------------------------------------------------| 
 */
package view.interfaces;

/**
 *
 * @author vovostudio
 */
public interface IModal {

    void setAcao(String acao);

    void setCadastro(String cadastro);

    void setObject(Object object) throws Exception;

    void setVisible(boolean b);
}
