/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaa.battleship.exception;

/**
 * Poikkeus, joka heitetään silloin kun peli loppuu.
 *
 * @author heaarnio
 */
public class GameEndedException extends RuntimeException {

    /**
     * Konstruktori, joka asettaa yläluokalle virheviestin.
     */
    public GameEndedException() {
        super("Game has ended.");
    }
}
