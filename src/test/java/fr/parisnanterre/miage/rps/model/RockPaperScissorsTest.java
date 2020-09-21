package fr.parisnanterre.miage.rps.model;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static fr.parisnanterre.miage.rps.model.Play.ROCK;
import static fr.parisnanterre.miage.rps.model.Play.SCISSORS;
import static fr.parisnanterre.miage.rps.model.Result.LOST;
import static fr.parisnanterre.miage.rps.model.Result.WIN;
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

    @Test
    public void testPlay() {
        assertEquals(rps.play(SCISSORS, ROCK), LOST);
    }
}