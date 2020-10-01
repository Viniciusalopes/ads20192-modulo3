/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 25/09/2020 17:32:08 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - DECORATOR
 *  Exercício  : ProgramadorBaseDecorator dos setores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Classe base para DECORATOR de habilidades de um profissional.
 *  -----------------------------------------------------------------------------------------------| 
 */
package model;

import java.util.ArrayList;
import util.EnumHabilidades;

/**
 *
 * @author vovostudio
 */
public abstract class ProgramadorBaseDecorator {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private ArrayList<EnumHabilidades> habilidades;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public ArrayList<EnumHabilidades> getHabilidades() {
        habilidades = new ArrayList<>();
        return habilidades;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    public abstract void setHabilidades(ArrayList<EnumHabilidades> habilidades);
    
    public abstract void addHabilidade(EnumHabilidades habilidade);

    public abstract void removeHabilidade(EnumHabilidades habilidade);

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
