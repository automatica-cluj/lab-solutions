package isp.lab3.exercise3;

public class FootballPlayer {
    private String name;
    private String team;
    private int goalsScored;
    private char gender;

    public FootballPlayer(String name, String team, char gender) {
        this.name = name;
        this.team = team;
        this.goalsScored = 0;

        if (gender == 'M' || gender == 'F') {
            this.gender = gender;
        } else {
            this.gender = 'M';
        }
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.gender + ") scored " + this.goalsScored + " goals for " + this.team;
    }
}
