package isp.lab3.exercise3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FootballPlayerTest {
    FootballPlayer footballPlayer1;
    FootballPlayer footballPlayer2;
    FootballPlayer footballPlayer3;

    @Before
    public void setup() {
        footballPlayer1 = new FootballPlayer("Lionel Messi", "FC Barcelona", 'M');
        footballPlayer2 = new FootballPlayer("Alex Morgan", "United States", 'F');
        footballPlayer3 = new FootballPlayer("ASD", "QWE", 'a');
    }

    @Test
    public void testConstructor() {
        FootballPlayer footballPlayer = new FootballPlayer("ASD", "QWE", 'a');
        assertEquals('M', footballPlayer.getGender());
        footballPlayer = new FootballPlayer("ASD", "QWE", 'F');
        assertEquals('F', footballPlayer.getGender());
        footballPlayer = new FootballPlayer("ASD", "QWE", 'M');
        assertEquals('M', footballPlayer.getGender());
    }

    @Test
    public void testGetName() {
        assertEquals("Lionel Messi", footballPlayer1.getName());
        assertEquals("Alex Morgan", footballPlayer2.getName());
        assertEquals("ASD", footballPlayer3.getName());
    }

    @Test
    public void testGetGender() {
        assertEquals('M', footballPlayer1.getGender());
        assertEquals('F', footballPlayer2.getGender());
        assertEquals('M', footballPlayer3.getGender());
    }

    @Test
    public void testGetTeam() {
        assertEquals("FC Barcelona", footballPlayer1.getTeam());
        assertEquals("United States", footballPlayer2.getTeam());
        assertEquals("QWE", footballPlayer3.getTeam());
    }

    @Test
    public void testSetTeam() {
        assertEquals("FC Barcelona", footballPlayer1.getTeam());
        assertEquals("United States", footballPlayer2.getTeam());
        assertEquals("QWE", footballPlayer3.getTeam());

        footballPlayer1.setTeam("FCSB");
        footballPlayer2.setTeam("Real Madrid");
        footballPlayer3.setTeam("ZXC");

        assertEquals("FCSB", footballPlayer1.getTeam());
        assertEquals("Real Madrid", footballPlayer2.getTeam());
        assertEquals("ZXC", footballPlayer3.getTeam());
    }

    @Test
    public void testGetGoalsScored() {
        assertEquals(0, footballPlayer1.getGoalsScored());
        assertEquals(0, footballPlayer2.getGoalsScored());
        assertEquals(0, footballPlayer3.getGoalsScored());
    }

    @Test
    public void testSetGoalsScored() {

        assertEquals(0, footballPlayer1.getGoalsScored());
        assertEquals(0, footballPlayer2.getGoalsScored());
        assertEquals(0, footballPlayer3.getGoalsScored());

        footballPlayer1.setGoalsScored(10);
        footballPlayer2.setGoalsScored(8);
        footballPlayer3.setGoalsScored(1);

        assertEquals(10, footballPlayer1.getGoalsScored());
        assertEquals(8, footballPlayer2.getGoalsScored());
        assertEquals(1, footballPlayer3.getGoalsScored());
    }

    @Test
    public void testToString() {
        assertEquals("Lionel Messi (M) scored 0 goals for FC Barcelona", footballPlayer1.toString());
        assertEquals("Alex Morgan (F) scored 0 goals for United States", footballPlayer2.toString());
        assertEquals("ASD (M) scored 0 goals for QWE", footballPlayer3.toString());
    }
}