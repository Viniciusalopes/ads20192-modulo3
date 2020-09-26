/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 25/09/2020 20:20:19 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - DECORATOR
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  
 *  -----------------------------------------------------------------------------------------------| 
 */
package model.habilidades;

import java.util.ArrayList;
import model.HabilidadesDecorator;
import model.skils.Programador;
import util.EnumHabilidades;

/**
 *
 * @author vovostudio
 */
public class Css extends HabilidadesDecorator {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private Programador programador;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Css(Programador programador) {
        this.programador = programador;
    }
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //

    //--- GET ------------------------------------------------------------------------------------->
    //
    @Override
    public ArrayList<EnumHabilidades> getHabilidades() {
        addHabilidade(EnumHabilidades.CSS);
        return programador.getHabilidades();
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    @Override
    public void addHabilidade(EnumHabilidades habilidade) {
        if (!programador.getHabilidades().contains(habilidade)) {
            programador.addHabilidade(habilidade);
        }
    }

    @Override
    public void removeHabilidade(EnumHabilidades habilidade) {
        programador.removeHabilidade(habilidade);
    }
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
