package isp.lab5.exercise5;

import org.junit.Test;

import static org.junit.Assert.*;

public class JungleTest {

    @Test
    public void testRemoveAnimalFromHerbivores() {
        //given
        Jungle jungle = new Jungle(Simulator.initializeHerbivores(), Simulator.initializeCarnivores());

        //pre assert
        assertEquals("There should be 20 animals in herbivores array", 20, jungle.getHerbivores().length);

        //when
        jungle.removeAnimalFromHerbivores(10);

        //post assert
        assertEquals("There should be 19 animals in herbivores array", 19, jungle.getHerbivores().length);
    }

    @Test
    public void removeAnimalFromCarnivores() {
        //given
        Jungle jungle = new Jungle(Simulator.initializeHerbivores(), Simulator.initializeCarnivores());

        //pre assert
        assertEquals("There should be 20 animals in carnivores array", 20, jungle.getCarnivores().length);

        //when
        jungle.removeAnimalFromCarnivores(10);

        //post assert
        assertEquals("There should be 19 animals in carnivores array", 19, jungle.getCarnivores().length);
    }
}