/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.przmnwck.games.calcmodule.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Przemysław
 */
public class Tournament {
    
    private int id;
    private RoundsSet rounds = new RoundsSet();

    public Set<Round> getRounds() {
        return rounds;
    }

    public void setRounds(RoundsSet rounds) {
        this.rounds = rounds;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private int nplayers;

    public Round getLastRound(){
        Iterator<Round> rit = rounds.iterator();
        Round cg=null;
        Round retRound=null;
        int n =0;
        while(rit.hasNext()){
            cg = rit.next();
            if(cg.getNumber()>n){
                retRound=cg;
                n=retRound.getNumber();
            }
        }
        return retRound;
    }
    
    /**
     * This method returns first unfinished round. This can be any round that is unfinished but is first
     * encountered by the iterator. It is, therefore, very important to finish the rounds
     * @return 
     */
    public Round getCurrentRound(){
        Iterator<Round> rit = rounds.iterator();
        Round cg=null;
        while(rit.hasNext()){
            cg = rit.next();
            if(!cg.isFinished()){
                return cg;
            }
        }
        return cg;
    }
    
    public int getNplayers() {
        return nplayers;
    }

    public void setNplayers(int nplayers) {
        this.nplayers = nplayers;
    }
    
}
