package fr.parisnanterre.miage.rps.model;

import org.testng.annotations.*;

import static fr.parisnanterre.miage.rps.model.Play.*;
import static fr.parisnanterre.miage.rps.model.Result.*;
import static org.testng.AssertJUnit.assertEquals;


public class RockPaperScissorsTest {

    RockPaperScissors rps = null;

    @BeforeMethod
    public void setUp() {
        rps = new RockPaperScissors();
    }

    @AfterMethod
    public void tearDown() {
        rps = null;
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

}