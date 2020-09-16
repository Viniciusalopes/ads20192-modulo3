/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 14/09/2020 06:46:27 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  Classe de objeto para cláusulas WHERE em consultas em banco PostgreSQL.
 *  ------------------------------------------------------------------------------------------------| 
 */
package dao.generic;

/**
 *
 * @author vovostudio
 */
public class Where extends Field {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private String andOr = "";
    private Comparer comparer;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Where() {
        
    }

    public Where(String andOr, String column_name, Comparer comparer, Object value) {
        this.andOr = andOr;
        this.column_name = column_name;
        this.comparer = comparer;
        this.value = value;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public String getAndOr() {
        return andOr;
    }

    public Comparer getComparer() {
        return comparer;
    }
    //--- FIM GET ---------------------------------------------------------------------------------|
    //

    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setAndOr(String andOr) {
        this.andOr = andOr;
    }

    public void setComparer(Comparer comparer) {
        this.comparer = comparer;
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
