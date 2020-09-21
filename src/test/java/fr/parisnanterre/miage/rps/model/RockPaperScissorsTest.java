package fr.parisnanterre.miage.rps.model;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static fr.parisnanterre.miage.rps.model.Play.*;
import static fr.parisnanterre.miage.rps.model.Result.*;
import static org.testng.AssertJUnit.assertEquals;


public class RockPaperScissorsTest {

    RockPaperScissors rps = null;

    Player player1;
    Player player2;
    Player player3;

    private void movesWin(List<Play> mouv){
        mouv.add(PAPER);
        mouv.add(SCISSORS);
        mouv.add(ROCK);
    }

    private void movesLost(List<Play> mouv){
        mouv.add(ROCK);
        mouv.add(PAPER);
        mouv.add(SCISSORS);
    }


    @BeforeMethod
    public void setUp() {
        rps = new RockPaperScissors();

        List<Play> mouvWin = new ArrayList<>();
        List<Play> mouvLost = new ArrayList<>();
        movesLost(mouvLost);
        movesWin(mouvWin);
        player1 = new Player("Ana", mouvWin);
        player2 = new Player("Marie", mouvLost);
        player3 = new Player("Jean", mouvWin);

    }

    @AfterMethod
    public void tearDown() {
        rps = null;

        player1 = null;
        player2 = null;
        player3 = null;
    }

    @Parameters({"papier", "pierre"})
    @Test
    public void testWin(String p1, String p2) {
        assertEquals(rps.play(Play.valueOf(p1), Play.valueOf(p2)), WIN);
    }

    @Parameters({"pierre", "pierre"})
    @Test
    public void testLost(String p1, String p2) {
        assertEquals(rps.play(Play.valueOf(p1), Play.valueOf(p2)), TIE);
    }

    @Parameters({"pierre", "papier"})
    @Test
    public void testTie(String p1, String p2) {
        assertEquals(rps.play(Play.valueOf(p1), Play.valueOf(p2)), LOST);
    }

    @DataProvider(name = "winData")
    public Object[][] createWinData() {
        return new Object[][]{{ PAPER, ROCK},
                {SCISSORS, PAPER},
                {ROCK, SCISSORS}};
    }

    @DataProvider(name = "lostData")
    public Object[][] createLostData() {
        return new Object[][]{{ROCK, PAPER},
                {PAPER, SCISSORS},
                {SCISSORS, ROCK}};
    }

    @DataProvider(name = "tieData")
    public Object[][] createTieData() {
        return new Object[][]{{ROCK, ROCK},
                {PAPER, PAPER},
                {SCISSORS, SCISSORS}};
    }

    @Test(dataProvider = "winData")
    public void testWinData(Play p1, Play p2){
        assertEquals(rps.play(p1, p2), WIN);
    }

    @Test(dataProvider = "lostData")
    public void testLostData(Play p1, Play p2){
        assertEquals(rps.play(p1, p2), LOST);
    }

    @Test(dataProvider = "tieData")
    public void testTieData(Play p1, Play p2){
        assertEquals(rps.play(p1, p2), TIE);
    }

    @Test
    public void testWinTour(){
        player3.resetIndexScore();
        player2.resetIndexScore();
        assertEquals(rps.play(player1, player2), WIN);
    }

    @Test
    public void testLostTour(){
        player3.resetIndexScore();
        player2.resetIndexScore();
        assertEquals(rps.play(player3, player2), WIN);
    }

    @Test
    public void testTieTour(){
        player3.resetIndexScore();
        player2.resetIndexScore();
        assertEquals(rps.play(player1, player1), WIN);
    }

}