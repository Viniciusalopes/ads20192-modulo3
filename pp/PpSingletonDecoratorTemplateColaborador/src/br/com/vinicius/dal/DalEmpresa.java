/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 10/10/2020 19:29:11 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE / FACTORY
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Acesso a dados da tabela [empresas].
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.dal;

import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.vinicius.model.Empresa;

/**
 *
 * @author vovostudio
 */
public class DalEmpresa extends br.com.vinicius.generic.dal.DalGeneric {

    private int empresa_id = 1;     // Fixo por que é só para uma empresa

    public DalEmpresa() throws Exception {
        super("empresas");
    }

    //--- GET ------------------------------------------------------------------------------------->
    //
    @Override
    protected ArrayList<?> build(ResultSet rs) throws Exception {
        ArrayList<Empresa> ret = new ArrayList<>();
        while (rs.next()) {
            Empresa empresa = new Empresa();
            empresa.setId(rs.getInt("empresa_id"));
            empresa.setNome(rs.getString("empresa_nome"));
            ret.add(empresa);
        }
        return ret;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public Empresa getEmpresa() throws Exception {
        sql = "SELECT * FROM empresas WHERE empresa_id = ?";
        args = new Object[]{empresa_id};
        return (Empresa) select().get(0);
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void update(String empresa_nome) throws Exception {
        sql = "UPDATE empresas SET empresa_nome = ? WHERE empresa_id = ?";
        args = new Object[]{empresa_nome, empresa_id};
        execute();
    }
    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
}
