/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tests.stubs;

import com.przmnwck.games.calcmodule.domain.Game;
import com.przmnwck.games.calcmodule.domain.Player;
import com.przmnwck.games.calcmodule.domain.Round;
import com.przmnwck.games.calcmodule.domain.Tournament;
import com.przmnwck.games.calcmodule.interfaces.ITournamentService;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Przemysław
 */
public class ITournamentServiceEvenNumberOfPlayersStub implements ITournamentService{

    boolean even = true;

    public boolean isEven() {
        return even;
    }

    public void setEven(boolean even) {
        this.even = even;
    }

    @Override
    public Tournament getTournament(int idTournament) {
        Tournament t = new Tournament();
        t.setId(idTournament);
        if(idTournament==1){
            t.setNplayers(6);
        } else if(idTournament==2){
            t.setNplayers(5);
        }
        return t;
    }

    @Override
    public void addNewRoundToTournament(Tournament tournament, Calendar c) {
        Round r = new Round();
        r.setDate(c);
        r.setNumber(tournament.getLastRound()!=null? tournament.getLastRound().getNumber()+1: 1);
        tournament.getRounds().add(r);
    }

    @Override
    public Set<Player> findPlayersToPlay(Round r) {
        int np=6;
        if(!even){
            np=7;
        }
        return getAllActivePlayers(np);
    }

    @Override
    public Set<Game> getGamesPlayedByPlayers(Tournament t, Player player1, Player player2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Set<Player> getAllActivePlayers(int i) {
        String names = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Set<Player> pSet = new HashSet<>();
        for(int n=0; n<i;n++){
            Player p = new Player(n+1);
            p.setName(new StringBuffer().append(names.charAt((i%names.length()))).toString());
            pSet.add(p);
            
        }
        return pSet;
    }
    
    

    
}
