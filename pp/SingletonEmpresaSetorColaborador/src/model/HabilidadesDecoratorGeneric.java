/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 27/09/2020 15:37:18 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - DECORATOR
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Classe genérica para métodos do HabilidadesDecorator
 *  -----------------------------------------------------------------------------------------------| 
 */
package model;

import java.util.ArrayList;
import util.EnumHabilidades;

/**
 *
 * @author vovostudio
 */
public class HabilidadesDecoratorGeneric extends HabilidadesDecorator {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private ProgramadorBaseDecorator programador;
    private EnumHabilidades habilidade;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public HabilidadesDecoratorGeneric(ProgramadorBaseDecorator programador) {
        this.programador = programador;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public ArrayList<EnumHabilidades> getHabilidades() {
        return programador.getHabilidades();
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    protected void setHabilidade(EnumHabilidades habilidade) {
        this.habilidade = habilidade;
    }

    @Override
    public void addHabilidade(EnumHabilidades habilidade) {
        if (!programador.getHabilidades().contains(habilidade)) {
            programador.addHabilidade(habilidade);
        }
    }

    @Override
    public void removeHabilidade(EnumHabilidades habilidade) {
        if (programador.getHabilidades().contains(habilidade)) {
            programador.removeHabilidade(habilidade);
        }
    }
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
