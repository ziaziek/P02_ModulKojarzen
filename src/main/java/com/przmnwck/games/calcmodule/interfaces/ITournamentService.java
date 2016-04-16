/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.przmnwck.games.calcmodule.interfaces;

import com.przmnwck.games.calcmodule.domain.Game;
import com.przmnwck.games.calcmodule.domain.Player;
import com.przmnwck.games.calcmodule.domain.Round;
import com.przmnwck.games.calcmodule.domain.Tournament;
import java.util.Calendar;
import java.util.Set;

/**
 *
 * @author Przemysław
 */
public interface ITournamentService {
    
    Tournament getTournament(int idTournament);
    
    void addNewRoundToTournament(Tournament t, Calendar c);
    
    Set<Player> findPlayersToPlay(Round r);
    
    public Set<Game> getGamesPlayedByPlayers(Tournament t, Player player1, Player player2);    
}