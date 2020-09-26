/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 25/09/2020 17:45:37 
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
package model.skils;

import java.util.ArrayList;
import util.EnumHabilidades;

/**
 *
 * @author vovostudio
 */
public class ProgramadorCSharp extends Programador {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private ArrayList<EnumHabilidades> habilidades;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public ProgramadorCSharp() {
        habilidades = super.getHabilidades();
        habilidades.add(EnumHabilidades.CSharp);
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public ArrayList<EnumHabilidades> getHabilidades() {
        return habilidades;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    public void addHabilidade(EnumHabilidades habilidade) {
        habilidades.add(habilidade);
    }

    public void removeHabilidade(EnumHabilidades habilidade) {
        habilidades.remove(habilidade);
    }
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
