/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaa.battleship.exception;

/**
 * Poikkeus, joka heitetään silloin kun pelaaja yrittää ampua uudelleen jo
 * kertaalleen ammuttuun ruutuun.
 *
 * @author heaarnio
 */
public class AlreadyShotException extends RuntimeException {

    /**
     * Konstruktori, joka asettaa yläluokalle virheviestin.
     */
    public AlreadyShotException() {
        super("The position is already shot. Try another one.");
    }
}
