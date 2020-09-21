package fr.parisnanterre.miage.rps.model;

import java.util.ArrayList;
import java.util.List;

public class GeneratorPlay {
    private static Play generatorFor(int nb){
        switch (nb){
            case 0 : return Play.ROCK;
            case 1 : return Play.SCISSORS;
            default : return Play.PAPER;
        }

    }

    private static Play generatePlay(){
        int x = (int) (Math.random()*3);
        return generatorFor(x);
    }

    public static List<Play> generatePlays(int taille){
        List<Play> rtr = new ArrayList<>(taille);
        for (int i=0; i<taille; i++){
            rtr.add(generatePlay());
        }
        return rtr;
    }
}
