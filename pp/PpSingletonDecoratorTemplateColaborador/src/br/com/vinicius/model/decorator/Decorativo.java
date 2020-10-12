/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 12/10/2020 07:39:39 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE / FACTORY
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Decorativo (Equivalente aos kits, trio elétrico, direção e ar do exemplo).
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.model.decorator;

import br.com.vinicius.bll.BllHabilidade;
import br.com.vinicius.model.Habilidade;
import java.util.ArrayList;

/**
 *
 * @author vovostudio
 */
public class Decorativo extends Profissional {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private Contratado contratado;
    private String habilidade_descricao;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Decorativo(Contratado contratado, String habilidade_descricao) {
        this.contratado = contratado;
        this.habilidade_descricao = habilidade_descricao;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    @Override
    public ArrayList<Habilidade> getHabilidades() throws Exception {
        ArrayList<Habilidade> ret = new ArrayList<>();
        boolean tem = false;
        for (Habilidade h : contratado.getHabilidades()) {
            ret.add(h);
            if (h.getDescricao().equals(habilidade_descricao)) {
                tem = true;
            }
        }
        if (!tem) {
            ret.add(BllHabilidade.getHabilidade(habilidade_descricao));
        }

        return ret;
    }

    @Override
    public int getQuantidade() throws Exception {
        return habilidades.size();
    }
    //--- FIM GET ---------------------------------------------------------------------------------|
    //
}
