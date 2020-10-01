/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

/**
 *
 * @author vovostudio
 */
public class CharFreq {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private int freq;
    private char ch;
    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //

    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public CharFreq() {

    }

    public CharFreq(int freq, char ch) {
        this.freq = freq;
        this.ch = ch;
    }
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //

    public int getFreq() {
        return freq;
    }

    public char getCh() {
        return ch;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setFreq(int freq) {
        this.freq = freq;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
