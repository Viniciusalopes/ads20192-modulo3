/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 25/09/2020 17:39:37 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - DECORATOR
 *  Exercício  : ProgramadorBaseDecorator dos setores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Classe DECORATOR para habilidades de um profissional.
 *  -----------------------------------------------------------------------------------------------| 
 */
package model;

import java.util.ArrayList;
import util.EnumHabilidades;

/**
 *
 * @author vovostudio
 */
public abstract class HabilidadesDecorator extends ProgramadorBaseDecorator {

    //--- GET ------------------------------------------------------------------------------------->
    //
    public abstract ArrayList<EnumHabilidades> getHabilidades();

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
}
