/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaa.battleship.model;

/**
 *
 * Abstrakti luokka, joka mallintaa pelaajaa.
 */
public abstract class Player {

    protected Grid grid;

    /**
     * Konstruktori luo uuden pelaajaa mallintavan olion.
     */
    public Player() {
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Grid getGrid() {
        return grid;
    }

    /**
     * Metodi palauttaa tiedon, onko pelaajalla laivoja vaiko ei.
     *
     * @return Boolean true, jos pelaajalla on laivoja ja false, jos ei ole.
     */
    public boolean hasShips() {
        return !(grid.getNavy().getShips().isEmpty());
    }
    
    public int getShipAmount() {
        return grid.getNavy().getShips().size();
    }

}
