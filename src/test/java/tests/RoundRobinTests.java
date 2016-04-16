package tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.przmnwck.games.calcmodule.calculators.RoundRobinCalculator;
import com.przmnwck.games.calcmodule.domain.Game;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tests.stubs.ITournamentServiceEvenNumberOfPlayersStub;

/**
 *
 * @author Przemysław
 */
public class RoundRobinTests {
    
    public RoundRobinTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void roundRobinCreatedTest() {
        assertNotNull(new RoundRobinCalculator());
    }
    
    @Test
    public void parametersSetCorrectlyTest() {
        RoundRobinCalculator calc = new RoundRobinCalculator();
        calc.setTournament(new ITournamentServiceEvenNumberOfPlayersStub().getTournament(1));
        assertEquals(1, calc.getTournament().getId());
    }
    
    @Test
    public void calcZeroRoundTest() {
        RoundRobinCalculator calc = new RoundRobinCalculator(new ITournamentServiceEvenNumberOfPlayersStub().getTournament(1));
        assertEquals(0, calc.getCurrentRoundNumber());
        assertEquals(15, calc.getTotalNumberOfGames());
        assertEquals(0, calc.getTournament().getRounds().size());
        assertEquals(3, calc.getMinimalNumberOfTables(calc.getTournament().getNplayers()));
        calc.setTournament(new ITournamentServiceEvenNumberOfPlayersStub().getTournament(2));
        assertEquals(10, calc.getTotalNumberOfGames());
        assertEquals(0, calc.getTournament().getRounds().size());
        assertEquals(2, calc.getMinimalNumberOfTables(calc.getTournament().getNplayers()));
    }
    
    
    
    @Test
    public void allRoundsGameSettingsEvenPlayersTest() {
        runTestForEvenorOddPlayers(true);
    }
    
    @Test
    public void allRoundsGamesSettingsForOddPlayersTest(){
        runTestForEvenorOddPlayers(false);
    }
    
    private void runTestForEvenorOddPlayers(boolean even){
        ITournamentServiceEvenNumberOfPlayersStub serv = new ITournamentServiceEvenNumberOfPlayersStub();
        serv.setEven(even);
        Calendar c = Calendar.getInstance();
        RoundRobinCalculator calc = new RoundRobinCalculator(serv.getTournament(1));
        for (int n = 0; n < serv.findPlayersToPlay(null).size(); n++) {
            serv.addNewRoundToTournament(calc.getTournament(), c);
            assertEquals(n + 1, calc.getTournament().getLastRound().getNumber());
            Set<Game> g = calc.calculateGamesForCurrentRound(serv.findPlayersToPlay(calc.getTournament().getCurrentRound()));
            assertNotNull(g);
            assertEquals(3, g.size());
            
            Set<Integer> playersPlaying = new HashSet<>();
            for (Game game : g) {
                assertNotNull(game.getDate());
                assertTrue(game.getTableNumber() > 0);
                assertNotNull(game.getWhite());
                assertNotNull(game.getBlack());
                assertNull(game.getResult());
                assertTrue(playersPlaying.add(game.getBlack().getId()));
                assertTrue(playersPlaying.add(game.getWhite().getId()));
            }
            calc.getTournament().getCurrentRound().setFinished(true);
            c.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
}
