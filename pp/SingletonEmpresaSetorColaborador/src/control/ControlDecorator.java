/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 26/09/2020 15:28:46 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - DECORATOR
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Centraliza operações do DECORATOR.
 *  -----------------------------------------------------------------------------------------------| 
 */
package control;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import model.ProgramadorBaseDecorator;
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
    
    private ProgramadorBaseDecorator programador = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public ControlDecorator() {
        programador = new ProgramadorPadrao();
    }
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //

    //--- GET ------------------------------------------------------------------------------------->
    //

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    public ArrayList<EnumHabilidades> getHabilidades() {
        return programador.getHabilidades();
    }

    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setHabilidades(ArrayList<EnumHabilidades> habilidades) {
        programador = new ProgramadorPadrao();
        for (EnumHabilidades habilidade : habilidades) {
            programador.addHabilidade(habilidade);
        }
    }

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
    public void addSkill(EnumSkills skill) throws Exception {
        try {
            Class<?> classe = Class.forName("model.habilidades.Programador" + skill.toString());
            Constructor construtor = classe.getConstructor(ProgramadorBaseDecorator.class);
            ProgramadorBaseDecorator pSkill = (ProgramadorBaseDecorator) construtor.newInstance(classe);

            for (EnumHabilidades habilidade : pSkill.getHabilidades()) {
                addHabilidade(habilidade);
            }
            
        } catch (Exception e) {
            throw new Exception("Erro ao adicionar skill!\n" + e.getMessage());
        }
    }

    public void addHabilidade(EnumHabilidades habilidade) throws Exception {
        /**
         * FONTES:<br>
         * https://stackoverflow.com/questions/10470263/create-new-object-using-reflection
         * https://stackoverflow.com/questions/2408789/getting-class-type-from-string
         * https://stackoverflow.com/questions/4767088/creating-an-instance-from-string-in-java
         * https://o.que.eu.ja.conhecia.de.reflection
         */

        try {
            Class<?> classe = Class.forName("model.habilidades." + habilidade.toString());
            Constructor construtor = classe.getConstructor(ProgramadorBaseDecorator.class);
            programador = (ProgramadorBaseDecorator) construtor.newInstance(programador);

        } catch (ClassNotFoundException ex) {
            // Não tem a classe do decorativo
            programador.addHabilidade(habilidade);
        }
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
