/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 25/09/2020 17:32:08 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - DECORATOR
 *  Exercício  : Programador dos setores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Classe base para DECORATOR de habilidades de um profissional.
 *  -----------------------------------------------------------------------------------------------| 
 */
package model.programadores;

import java.util.ArrayList;
import util.EnumHabilidades;

/**
 *
 * @author vovostudio
 */
public abstract class Programador {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private ArrayList<EnumHabilidades> habilidades;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public ArrayList<EnumHabilidades> getHabilidades() {
        habilidades = new ArrayList<>();
        habilidades.add(EnumHabilidades.Analisar);
        habilidades.add(EnumHabilidades.Pesquisar);
        habilidades.add(EnumHabilidades.Estudar);
        habilidades.add(EnumHabilidades.Programar);
        habilidades.add(EnumHabilidades.BeberCafe);
        habilidades.add(EnumHabilidades.CriarBugs);
        return habilidades;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    public abstract void addHabilidade(EnumHabilidades habilidade);

    public abstract void removeHabilidade(EnumHabilidades habilidade);

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
