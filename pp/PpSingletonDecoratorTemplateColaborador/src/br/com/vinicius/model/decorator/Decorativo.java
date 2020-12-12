/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 12/10/2020 07:39:39 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
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
    /**
     * Cria um objeto a ser decorado a partir de outro que extenda o decorador (Profissional) e
     * INCLUI a habilidade decorativa.
     *
     * @param contratado Objeto decorado a ser modificado.
     * @param habilidade_descricao Habilidade que corresponde ao decorativo.
     */
    public Decorativo(Contratado contratado, String habilidade_descricao) {
        this.contratado = contratado;
        this.habilidade_descricao = habilidade_descricao;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    /**
     * Inclui as habilidades do objeto injetado no construtor e inclui a habilidade correspondente
     * do decorativo somente se ela ainda não existir.
     *
     * @return @throws Exception
     */
    
    // No exemplo dado:
    //Retorna um Objeto String composto de chars acrescido de outra string
    //public String getDescricao(){
    //    return veiculo.getDescricao() + ", Kit Turbo 3000";
                
        // Obtem uma String com descrição        // acrescenta um texto à descricao
        //return veiculo.getDescricao()                  + ", Kit Turbo 3000";
    //}
    
    
    // Se eu fizesse assim, seria decorator?    R:
    
    //Retorna um Objeto String composto de chars acrescido de outra string
    public String get_Habilidades() throws Exception {
        // Obtem o objeto String com as habilidades    // acrescenta a habilidade decorativa
        
        
        return contratado.getHabilidades().toString() + this.habilidade_descricao;
        
        // Neste caso, a forma de adicionar um texto ao retorno é um sinal de '+'
        // Obtem o objeto String com as habilidades      // acrescenta a habilidade decorativa
        // return contratado.getHabilidades().toString() + this.habilidade_descricao;
    }

    
    
    
    
    // Se eu substituir:
    // - String por ArrayList,
    // - char por Habilidade e
    // - texto por consulta ao banco
    //
    // descaracteriza o padrão decorator por que?
    
    //Retorna um Objeto Arraylist composto de objetos Habilidade acrescido de outro objeto
    @Override
    public ArrayList<Habilidade> getHabilidades() throws Exception {

        // Obtém os objetos Habilidade do contratado passado por parâmetro no construtor
        //---------------------- contratado.getHabilidades()  -----------------------
    
        ArrayList<Habilidade> ret = new ArrayList<>();
        boolean tem = false;
        for (Habilidade h : contratado.getHabilidades()) {
            ret.add(h);
            if (h.getDescricao().equals(habilidade_descricao)) {
                tem = true;
            }
        }
        //---------------------- contratado.getHabilidades()  -----------------------

        
        // acrescenta a habilidade decorativa
        //----------------------  + this.habilidade_descricao ------------------------
        if (!tem) {
            ret.add(BllHabilidade.getHabilidade(habilidade_descricao));
        }
        
        return ret;
        
        // ret.add(BllHabilidade.getHabilidade(habilidade_descricao));
        //
        // neste caso, a forma de adicionar a habilidade ao retorno, é o método 'add'
        

        
        //----------------------  + this.habilidade_descricao ------------------------
    }

    @Override
    public int getQuantidade() throws Exception {
        return this.getHabilidades().size();
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
}
