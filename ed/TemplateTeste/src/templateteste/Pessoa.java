/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templateteste;

/**
 *
 * @author vovostudio
 */
public class Pessoa {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private String nome = "";
    private String curso = "";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    public Pessoa() {

    }

    public Pessoa(String nome, String curso) {
        this.nome = nome;
        this.curso = curso;
    }
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }
    //--- FIM GET ---------------------------------------------------------------------------------|
    //

    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setNome(String nome) {
        this.nome = nome;

    }

    public void setCurso(String curso) {
        this.curso = curso;
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
    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
