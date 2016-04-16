/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.przmnwck.games.calcmodule.domain;

import java.util.Calendar;

/**
 *
 * @author Przemysław
 */
public class Game {
    
    private final Player white, black;

    public Player getWhite() {
        return white;
    }

    public Player getBlack() {
        return black;
    }

    public Calendar getDate() {
        return date;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public GameResult getResult() {
        return result;
    }

    public void setResult(GameResult result) {
        this.result = result;
    }
    private Calendar date;
    private int tableNumber;
    private GameResult result;
    
    public Game(Player whitePlayer, Player blackPlayer){
        this.white=whitePlayer;
        this.black=blackPlayer;
    }
    
    public Game(Player whitePlayer, Player blackPlayer, Calendar date, int tableNo){
        this(whitePlayer, blackPlayer);
        this.date=date;
        this.tableNumber=tableNo;
    }
}
