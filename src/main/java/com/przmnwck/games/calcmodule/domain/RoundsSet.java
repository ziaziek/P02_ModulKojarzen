/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.przmnwck.games.calcmodule.domain;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Przemysław
 */
public class RoundsSet extends HashSet<Round> {

    @Override
    public boolean add(Round e) {
        Iterator<Round> rit = this.iterator();
        while(rit.hasNext()){
            if(!rit.next().isFinished()){
                return false;
            }
        }
        return super.add(e);
    }
    
    
}
