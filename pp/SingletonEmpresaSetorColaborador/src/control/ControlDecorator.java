/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 26/09/2020 15:28:46 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - DECORATOR / SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Centraliza operações do DECORATOR.
 *  -----------------------------------------------------------------------------------------------| 
 */
package control;

import java.util.ArrayList;
import model.skills.Programador;
import model.skills.ProgramadorPadrao;
import util.EnumHabilidades;
import util.EnumSkills;

/**
 *
 * @author vovostudio
 */
public class ControlDecorator {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private static ControlDecorator control = null;
    private Programador programador = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    private ControlDecorator() {

    }
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //

    //--- GET ------------------------------------------------------------------------------------->
    //
    public static ControlDecorator getInstance() {
        if (control == null) {
            control = new ControlDecorator();
        }
        return control;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    public ArrayList<EnumHabilidades> getHabilidades(){
        return programador.getHabilidades();
    }
    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setHabilidades(ArrayList<EnumHabilidades> habilidades){
        programador
    }
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public void newProgramadorPadrao() {
        programador = new ProgramadorPadrao();
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void addSkill(EnumSkills skill) {

    }

    public void addHabilidade(EnumHabilidades habilidade) {

    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public void removeHabilidade(EnumHabilidades habilidade) {

    }
    
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
