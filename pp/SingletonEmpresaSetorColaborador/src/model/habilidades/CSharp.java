/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 27/09/2020 20:20:19 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - DECORATOR
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Classe do acessório decorativo.
 *  -----------------------------------------------------------------------------------------------| 
 */
package model.habilidades;

import model.HabilidadesDecoratorGeneric;
import model.ProgramadorBaseDecorator;
import util.EnumHabilidades;

/**
 *
 * @author vovostudio
 */
public class CSharp extends HabilidadesDecoratorGeneric {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private EnumHabilidades habilidade = EnumHabilidades.valueOf(this.getClass().getName());

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public CSharp(ProgramadorBaseDecorator programador) {
        super(programador);
        super.setHabilidade(habilidade);
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
}