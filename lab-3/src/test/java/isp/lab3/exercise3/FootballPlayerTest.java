package isp.lab3.exercise3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FootballPlayerTest {
    FootballPlayer footballPlayer1;
    FootballPlayer footballPlayer2;
    FootballPlayer footballPlayer3;

    @Before
    public void setUp() {
        footballPlayer1 = new FootballPlayer("Lionel Messi", "FC Barcelona", 'M');
        footballPlayer2 = new FootballPlayer("Alex Morgan", "United States", 'F');
        footballPlayer3 = new FootballPlayer("ASD", "QWE", 'a');
    }

    @Test
    public void testGetName() {
        assertEquals("The name should be \"Lionel Messi\"", "Lionel Messi", footballPlayer1.getName());
        assertEquals("The name should be \"Alex Morgan\"", "Alex Morgan", footballPlayer2.getName());
        assertEquals("The name should be \"ASD\" because no validation was added for the name", "ASD", footballPlayer3.getName());
    }

    @Test
    public void testGetGender() {
        assertEquals("The gender should be 'M'", 'M', footballPlayer1.getGender());
        assertEquals("The gender should be 'F'", 'F', footballPlayer2.getGender());
        assertEquals("The gender should be 'M' as the given one was a bad one", 'M', footballPlayer3.getGender());
    }

    @Test
    public void testGetTeam() {
        assertEquals("The team should be \"FC Barcelona\"", "FC Barcelona", footballPlayer1.getTeam());
        assertEquals("The team should be \"United States\"", "United States", footballPlayer2.getTeam());
        assertEquals("The team should be \"QWE\" because no validation was added for the team", "QWE", footballPlayer3.getTeam());
    }

    @Test
    public void testSetTeam() {
        assertEquals("The team should be \"FC Barcelona\"", "FC Barcelona", footballPlayer1.getTeam());
        assertEquals("The team should be \"United States\"", "United States", footballPlayer2.getTeam());
        assertEquals("The team should be \"QWE\" because no validation was added for the team", "QWE", footballPlayer3.getTeam());

        footballPlayer1.setTeam("FCSB");
        footballPlayer2.setTeam("Real Madrid");
        footballPlayer3.setTeam("ZXC");

        assertEquals("The team should be \"FCSB\"", "FCSB", footballPlayer1.getTeam());
        assertEquals("The team should be \"Real Madrid\"", "Real Madrid", footballPlayer2.getTeam());
        assertEquals("The team should be \"ZXC\"", "ZXC", footballPlayer3.getTeam());
    }

    @Test
    public void testGetGoalsScored() {
        assertEquals(0, footballPlayer1.getGoalsScored());
        assertEquals("The goals scored should be 0 as the new player didn't score any goal yet", 0, footballPlayer1.getGoalsScored());
        assertEquals(0, footballPlayer2.getGoalsScored());
        assertEquals("The goals scored should be 0 as the new player didn't score any goal yet", 0, footballPlayer2.getGoalsScored());
        assertEquals(0, footballPlayer3.getGoalsScored());
        assertEquals("The goals scored should be 0 as the new player didn't score any goal yet", 0, footballPlayer3.getGoalsScored());
    }

    @Test
    public void testSetGoalsScored() {

        assertEquals("The goals scored should be 0 as the new player didn't score any goal yet", 0, footballPlayer1.getGoalsScored());
        assertEquals("The goals scored should be 0 as the new player didn't score any goal yet", 0, footballPlayer2.getGoalsScored());
        assertEquals("The goals scored should be 0 as the new player didn't score any goal yet", 0, footballPlayer3.getGoalsScored());

        footballPlayer1.setGoalsScored(10);
        footballPlayer2.setGoalsScored(8);
        footballPlayer3.setGoalsScored(1);

        assertEquals("The goals scored should be 1", 10, footballPlayer1.getGoalsScored());
        assertEquals("The goals scored should be 1", 8, footballPlayer2.getGoalsScored());
        assertEquals("The goals scored should be 1", 1, footballPlayer3.getGoalsScored());
    }

    @Test
    public void testToString() {
        assertEquals("The toString method should have the proper format", "Lionel Messi (M) scored 0 goals for FC Barcelona", footballPlayer1.toString());
        assertEquals("The toString method should have the proper format", "Alex Morgan (F) scored 0 goals for United States", footballPlayer2.toString());
        assertEquals("The toString method should have the proper format", "ASD (M) scored 0 goals for QWE", footballPlayer3.toString());
    }
}