package fr.parisnanterre.miage.rps.model;

import java.util.List;

public class Player {
    private String nom;
    private int score;
    private List<Play> mouvements;
    private int currMouv;

    public Player(String nom){
        this.nom=nom;
        this.mouvements= GeneratorPlay.generatePlays(10);
        currMouv = 0;
    }

    public Player(String nom, List<Play> mouvements){
        this(nom);
        this.mouvements = mouvements;
    }

    public String getNom(){
        return nom;
    }

    public int getScore(){
        return score;
    }

    public int getMouvements(){
        return mouvements.size();
    }

    public Play getNexMove(){
        currMouv++;
        return mouvements.get(currMouv - 1);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void resetScore(){
        setScore(0);
        currMouv=0;
    }
}
