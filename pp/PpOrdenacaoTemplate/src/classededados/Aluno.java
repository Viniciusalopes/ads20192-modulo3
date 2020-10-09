/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 02/10/2020 18:49:34 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - TEMPLATE METHOD
 *  Exercício  : Métodos de ordenação
 *  ------------------------------------------------------------------------------------------------
 *  
 *  -----------------------------------------------------------------------------------------------| 
 */
package classededados;

/**
 *
 * @author vovostudio
 */
public class Aluno {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private String nome;
    private String curso;
    private String situacao;
    private String enfase;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Aluno() {

    }

    public Aluno(String alunoToString) {
        String[] partes = alunoToString.split(";");
        nome = partes[0];
        curso = partes[1];
        situacao = partes[2];
        enfase = partes[3];
    }

    public Aluno(String nome, String curso, String situacao, String enfase) {
        this.nome = nome;
        this.curso = curso;
        this.situacao = situacao;
        this.enfase = enfase;
    }

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

    public String getSituacao() {
        return situacao;
    }

    public String getEnfase() {
        return enfase;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setEnfase(String enfase) {
        this.enfase = enfase;
    }

    //--- SET ------------------------------------------------------------------------------------->
    //
}
