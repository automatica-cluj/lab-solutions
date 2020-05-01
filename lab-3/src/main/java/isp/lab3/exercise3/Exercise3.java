package isp.lab3.exercise3;

import java.util.Random;

public class Exercise3 {

    public static void main(String[] args) {
        FootballPlayer footballPlayer = new FootballPlayer("Cristiano Ronaldo", "Juventus", 'M');
        System.out.println(footballPlayer.getGoalsScored());
        System.out.println(footballPlayer.getTeam());
        System.out.println(footballPlayer.getGender());
        System.out.println(footballPlayer.getName());
        System.out.println(footballPlayer);

        footballPlayer.setGoalsScored(22);
        System.out.println(footballPlayer.getGoalsScored());
        footballPlayer.setTeam("SS Lazio");
        System.out.println(footballPlayer.getTeam());

        Random random = new Random();
        int randomGoalsScored = random.nextInt(15) + 15;
        FootballPlayer footballPlayer2 = new FootballPlayer("Cristiano Ronaldo", "Juventus", 'M');
        footballPlayer2.setGoalsScored(randomGoalsScored);
        System.out.println(footballPlayer2);
    }
}
