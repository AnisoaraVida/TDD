package fr.parisnanterre.miage.rps.model;

public class RockPaperScissors {

    Result play(Play p1, Play p2){
        if ( p1==p2 ){
            return Result.TIE;
        }

        if ( p1==Play.SCISSORS && p2==Play.PAPER){
            return Result.WIN;
        }

        if ( p1==Play.ROCK && p2==Play.SCISSORS){
            return Result.WIN;
        }

        if ( p1==Play.PAPER && p2==Play.ROCK){
            return Result.WIN;
        }
        return Result.LOST;
    }

    Result play(Player p1, Player p2){
        Result result;
        for(int i=0; i<p1.getMouvements(); i++){
            result= play(p1.getNexMove(), p2.getNexMove());
            if(result==Result.TIE){
                p1.setScore(p1.getScore()+1);
                p2.setScore(p2.getScore()+1);
            }
            if(result==Result.WIN){
                p1.setScore(p1.getScore()+1);
            }
            else{
                p2.setScore(p2.getScore()+1);
            }
        }

        if(p1.getScore() > p2.getScore()){
            return Result.WIN;
        }
        else if(p1.getScore()==p2.getScore()){
            return Result.TIE;
        }
        else{
            return Result.LOST;
        }
    }

}
