/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 12/09/2020 09:25:17 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  Controle para manipulação de dados da Empresa.
 *  ------------------------------------------------------------------------------------------------| 
 */
package control;

import static bll.BllGeneric.validarNome;
import dao.generic.Comparer;
import dao.DAOSetor;
import dao.DAOEmpresa;
import dao.generic.Where;
import java.util.ArrayList;
import model.Empresa;
import model.Setor;
import static view.Mensagem.*;

/**
 *
 * @author vovostudio
 */
public class ControlEmpresa {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private static ControlEmpresa control = null;
    private static DAOEmpresa daoEmpresa = null;
    private static DAOSetor daoSetor = null;
    private Empresa empresa = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    private ControlEmpresa() throws Exception {
        daoEmpresa = new DAOEmpresa();
        daoSetor = new DAOSetor();
        empresa = daoEmpresa.retrieveById(1);
    }
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //

    //--- GET ------------------------------------------------------------------------------------->
    //
    public static ControlEmpresa getInstance() throws Exception {
        if (control == null) {
            control = new ControlEmpresa();
        }
        return control;
    }

    public Setor getSetor(int idSetor) {
        for (Setor setor : empresa.getSetores()) {
            if (setor.getId() == idSetor) {
                return setor;
            }
        }
        return null;
    }
    //--- FIM GET ---------------------------------------------------------------------------------|
    //

    public Empresa getEmpresa() {
        return empresa;
    }

    public Object[] getLinhasSetores() throws Exception {

        ArrayList<Setor> setores = empresa.getSetores();
        Object[] linhas = new Object[setores.size()];
        for (int i = 0; i < setores.size(); i++) {
            Setor setor = setores.get(i);
            linhas[i] = new Object[]{setor.getId(), setor.getNome(), setor.getColaboradores().size()};
        }
        return linhas;
    }

    public Object[] getLinhasColaboradores() {
        return new Object[]{};
    }

    //--- SET ------------------------------------------------------------------------------------->
    //
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public void IncluirSetor(String nome) throws Exception {
        validarNome(nome);
        Setor setor = new Setor(
                daoSetor.getMaxId("setor_id") + 1,
                nome,
                null,
                empresa.getId()
        );
        try {
            daoSetor.add(setor);
        } catch (Exception e) {
            if (e.toString().contains("ERROR: duplicate key value violates unique constraint \"setores_setor_nome_key\"")) {
                throw new Exception("Já existem um setor com este nome!");
            }
            else{
                throw e;
            }
        }
        ArrayList<Setor> setores = empresa.getSetores();
        setores.add(setor);
        empresa.setSetores(setores);
    }

    public void IncluirColaborador(String nome) {
        mensagem("Reflection2", nome);
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void EditarSetor(int id, String nome) throws Exception {
        validarNome(nome);
        Setor setor = new Setor(
                id,
                nome,
                null,
                empresa.getId()
        );
        
        try {
            daoSetor.update(setor);
        } catch (Exception e) {
            if (e.toString().contains("ERROR: duplicate key value violates unique constraint \"setores_setor_nome_key\"")) {
                throw new Exception("Já existem um setor com este nome!");
            }
            else{
                throw e;
            }
        }
        updateSetores();
    }

    public void EditarColaborador(String nome) {
        mensagem("Reflection3", nome);
    }

    public void updateSetores() throws Exception {
        empresa.setSetores(daoSetor.retrieveByField(
                null,
                new Where("", "setor_empresa_id", Comparer.EQUAL, empresa.getId()))
        );
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public void ExcluirSetor(int id) throws Exception {
        daoSetor.delete(id);
        updateSetores();
    }

    public void ExcluirColaborador(String nome) {
        mensagem("Reflection2", nome);
    }

    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
