/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import classes.Jogador;
import classes.Tabuleiro;

/**
 *
 * @author vovostudio
 */
public class ProjetoWAR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Jogador godofredo = new Jogador("Godofredo das couves", Tabuleiro.getTabuleiro());
        Jogador orozimbo = new Jogador("Orozimbo dos pepinos", Tabuleiro.getTabuleiro());
        Jogador mabuco = new Jogador("Godofredo das couves", Tabuleiro.getTabuleiro());
    }
}