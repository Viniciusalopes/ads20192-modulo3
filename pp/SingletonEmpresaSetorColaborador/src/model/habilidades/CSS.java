/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 27/09/2020 20:20:19 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - DECORATOR
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Classe do acessório decorativo.
 *  -----------------------------------------------------------------------------------------------| 
 */
package model.habilidades;

import java.util.ArrayList;
import model.HabilidadesDecorator;
import model.ProgramadorBaseDecorator;
import util.EnumHabilidades;

/**
 *
 * @author vovostudio
 */
public class CSS extends HabilidadesDecorator {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private ProgramadorBaseDecorator programador;
    private ArrayList<EnumHabilidades> habilidades;
    private EnumHabilidades habilidade = EnumHabilidades.valueOf(this.getClass().getSimpleName());

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public CSS(ProgramadorBaseDecorator programador) {
        this.programador = programador;
        this.programador.setHabilidades(programador.getHabilidades());
        this.addHabilidade(habilidade);
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
    public void setHabilidades(ArrayList<EnumHabilidades> habilidades) {
        this.habilidades = habilidades;
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
