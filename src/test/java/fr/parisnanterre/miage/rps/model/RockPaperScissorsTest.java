package fr.parisnanterre.miage.rps.model;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static fr.parisnanterre.miage.rps.model.Play.ROCK;
import static fr.parisnanterre.miage.rps.model.Play.SCISSORS;
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
    public void testPlay(String p1, String p2) {
        assertEquals(rps.play(Play.valueOf(p1), Play.valueOf(p2)), WIN);
    }

    @Parameters({"pierre", "pierre"})
    @Test
    public void testPlay1(String p1, String p2) {
        assertEquals(rps.play(Play.valueOf(p1), Play.valueOf(p2)), LOST);
    }

    @Parameters({"pierre", "papier"})
    @Test
    public void testPlay2(String p1, String p2) {
        assertEquals(rps.play(Play.valueOf(p1), Play.valueOf(p2)), WIN);
    }
}