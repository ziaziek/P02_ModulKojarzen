/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.przmnwck.games.calcmodule.domain;

/**
 *
 * @author Przemysław
 */
public class Player {
    
    private final int id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    
    public Player(int id){
        this.id=id;
    }
}
