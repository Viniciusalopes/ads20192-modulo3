/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 12/09/2020 09:25:17 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
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
import dao.DAOColaborador;
import dao.generic.util.Comparer;
import dao.DAOSetor;
import dao.DAOEmpresa;
import dao.DAOHabilidade;
import dao.generic.model.Where;
import java.util.ArrayList;
import model.Colaborador;
import model.Empresa;
import model.Setor;
import static util.VectorUtil.redimVector;

/**
 *
 * @author vovostudio
 */
public class ControlEmpresa {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private static ControlEmpresa control = null;
    private static ControlSetor controlSetor = null;
    private static ControlColaborador controlColaborador = null;
    private static DAOEmpresa daoEmpresa = null;
    private static DAOSetor daoSetor = null;
    private static DAOColaborador daoColaborador = null;
    private static DAOHabilidade daoHabilidade = null;

    private Empresa empresa = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    private ControlEmpresa() throws Exception {
        controlSetor = new ControlSetor();
        controlColaborador = new ControlColaborador();
        daoEmpresa = new DAOEmpresa();
        daoSetor = new DAOSetor();
        daoColaborador = new DAOColaborador();
        daoHabilidade = new DAOHabilidade();

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

    public Setor getSetor(int idSetor) throws Exception {
        return daoSetor.retrieveById(idSetor);
    }

    public Setor getSetor(String nome) throws Exception {
        return daoSetor.retrieveByField(null, new Where("", "setor_nome", Comparer.EQUAL, nome)).get(0);
    }

    public Colaborador getColaborador(int idColaborador) throws Exception {
        return daoColaborador.retrieveById(idColaborador);
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    public Empresa getEmpresa() {
        return empresa;
    }

    public Object[] getLinhasSetores() throws Exception {
        // Atualiza a lista de setores no objeto empresa
        updateAll();
        ArrayList<Setor> setores = empresa.getSetores();
        Object[] linhas = new Object[setores.size()];
        for (int i = 0; i < setores.size(); i++) {
            Setor setor = setores.get(i);
            int qtd = setor.getColaboradores().size();
            linhas[i] = new Object[]{setor.getId(), setor.getNome(), qtd};
        }
        return linhas;
    }

    public Object[] getLinhasColaboradores() throws Exception {
        // Atualiza a lista de colaboradores dos setores da empresa
        updateAll();
        Object[] linhas = new Object[0];

        int i = 0;
        ArrayList<Setor> setores = empresa.getSetores();
        for (Setor setor : setores) {
            ArrayList<Colaborador> colaboradores = setor.getColaboradores();
            linhas = redimVector(linhas, colaboradores.size());
            for (; i < colaboradores.size(); i++) {
                Colaborador colaborador = colaboradores.get(i);
                linhas[i] = new Object[]{colaborador.getId(), colaborador.getNome(), setor.getNome()};
            }
        }
        return linhas;
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
            } else {
                throw e;
            }
        }
        ArrayList<Setor> setores = empresa.getSetores();
        setores.add(setor);
        empresa.setSetores(setores);
    }

    public void IncluirColaborador(String nome, Setor setor) throws Exception {
        validarNome(nome);
        Colaborador colaborador = new Colaborador(
                daoColaborador.getMaxId("colaborador_id") + 1,
                nome, setor
        );
        daoColaborador.add(colaborador);
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
            } else {
                throw e;
            }
        }
        updateAll();
    }

    public void EditarColaborador(int id, String nome, Setor setor) throws Exception {
        validarNome(nome);
        Colaborador colaborador = new Colaborador(id, nome, setor);
        try {
            daoColaborador.update(colaborador);
        } catch (Exception e) {
            if (e.toString().contains("ERROR: duplicate key value violates unique constraint \"colaboradores_colaborador_nome_key\"")) {
                throw new Exception("Já existem um colaborador com este nome!");
            } else {
                String msg = e.getMessage();
                throw e;
            }
        }
    }

    public void updateAll() throws Exception {
        updateSetores();
        updateColaboradores();
    }

    public void updateSetores() throws Exception {
        empresa.setSetores(daoSetor.retrieveByField(
                null,
                new Where("", "setor_empresa_id", Comparer.EQUAL, empresa.getId()))
        );
    }

    public void updateColaboradores() throws Exception {
        ArrayList<Setor> setores = empresa.getSetores();
        for (Setor setor : setores) {
            ArrayList<Colaborador> colaboradores = controlColaborador.getListaColaboradores(setor.getId());
            setor.setColaboradores(colaboradores);
        }
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public void ExcluirSetor(int id) throws Exception {
        daoSetor.delete(id);
        updateAll();
    }

    public void ExcluirColaborador(int id) throws Exception {
        daoColaborador.delete(id);
        updateAll();
    }

    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
