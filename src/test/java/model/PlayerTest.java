package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testGetName() {
        final String inputValue = "Max";
        final String exceptedValue = inputValue;

        final Player player = new Player(inputValue, null);

        final String actualValue = player.getName();

        assertEquals(exceptedValue, actualValue);
    }

    @Test
    public void testGetFigure() {
        final Figure inputValue = Figure.O;
        final Figure exceptedValue = inputValue;

        final Player player = new Player(null, inputValue);

        final Figure actualValue = player.getFigure();

        assertEquals(exceptedValue, actualValue);
    }
}