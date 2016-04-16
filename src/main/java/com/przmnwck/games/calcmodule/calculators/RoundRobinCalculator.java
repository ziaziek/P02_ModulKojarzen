package com.przmnwck.games.calcmodule.calculators;

import com.przmnwck.games.calcmodule.domain.Game;
import com.przmnwck.games.calcmodule.domain.Player;
import com.przmnwck.games.calcmodule.domain.Tournament;
import com.przmnwck.games.calcmodule.interfaces.ITournamentService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Przemysław
 */
public class RoundRobinCalculator {

    private Tournament tournament;

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public RoundRobinCalculator() {
    }

    public RoundRobinCalculator(Tournament t) {
        tournament = t;
    }

    public int getCurrentRoundNumber() {
        if(tournament!=null && tournament.getCurrentRound()==null){
            return 0;
        } else {
            return tournament.getCurrentRound().getNumber();
        }
    }

    public int getTotalNumberOfGames() {
        return (int) (tournament.getNplayers() * (tournament.getNplayers() - 1) / 2);
    }

    public int getMinimalNumberOfTables(int activePlayers) {
        return (int) activePlayers / 2;
    }

    /**
     * Calculates games for the current rond in a round table manner
     *
     * @param playersToPlay an ordered by id set of players to play the round
     * @return A set of games to be played in the current round
     */
    public Set<Game> calculateGamesForCurrentRound(Set<Player> playersToPlay) {
        Set<Game> games = new HashSet<>();
        if (!tournament.getRounds().isEmpty()) {
            int rn = tournament.getCurrentRound().getNumber();
            Player[] ps = playersToPlay.toArray(new Player[playersToPlay.size()]);
            int s =  playersToPlay.size();
            for (int i = 0; i < playersToPlay.size()/2; i++) {
                games.add(new Game(ps[(rn+i-1)%s], ps[(s+rn-i-2)%s], tournament.getCurrentRound().getDate(), (i + 1)));
            }
        }

        return games;
    }
}
