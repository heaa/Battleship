/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaa.battleship.controller;

import heaa.battleship.model.GameSettings;

/**
 *
 * Abstrakti luokka, joka pitää sisällään peliasetukset.
 */
public abstract class Controller {
    protected GameSettings gameSettings;

    
    public GameSettings getGameSettings() {
        return gameSettings;
    }
    
}
