package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void testGetX() {
        final int inputValueX = 1;
        final int exceptedValue = inputValueX;

        final Point point = new Point(inputValueX, 0);

        final int actualValue = point.getX();

        assertEquals(exceptedValue, actualValue);
    }

    @Test
    public void testGetY() {
        final int inputValueY = 1;
        final int exceptedValue = inputValueY;

        final Point point = new Point(0, inputValueY);

        final int actualValue = point.getY();

        assertEquals(exceptedValue, actualValue);
    }
}