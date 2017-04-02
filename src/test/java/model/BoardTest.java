package model;

import exceptions.InvalidCoordinateException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

public class BoardTest {

    @Test
    public void testSetFigures() {
        final int sizeField = 3;
        final int valueX = 0;
        final int valueY = valueX;

        final Point point = new Point(valueX, valueY);
        final Figure inputFigure = Figure.X;
        final Figure expectedFigure = inputFigure;
        final Board board = new Board(sizeField, sizeField);

        try {
            board.setFigures(inputFigure, point);
        } catch (InvalidCoordinateException e) {
            e.printStackTrace();
        }

        Figure actualFigure = board.getFigure(point);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void testSetFiguresWithInvalidCoordinate() {
        final int sizeField = 3;
        final int valueX = -1;
        final int valueY = valueX;

        final Point point = new Point(valueX, valueY);
        final Figure inputFigure = Figure.X;
        final Board board = new Board(sizeField, sizeField);

        try {
            board.setFigures(inputFigure, point);
            fail();
        } catch (InvalidCoordinateException e) {}
    }

    @Test
    public void testGetFiguresNotValidateValueXLessMin() {
        final int sizeField = 3;
        final int valueX = -1;
        final int valueY = 0;

        final Point point = new Point(valueX, valueY);
        final Board board = new Board(sizeField, sizeField);

        final Figure actualFigure = board.getFigure(point);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFiguresNotValidateValueXMoreMax() {
        final int sizeField = 3;
        final int valueX = 4;
        final int valueY = 0;

        final Point point = new Point(valueX, valueY);
        final Board board = new Board(sizeField, sizeField);

        final Figure actualFigure = board.getFigure(point);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFiguresNotValidateValueYLessMin() {
        final int sizeField = 3;
        final int valueX = 0;
        final int valueY = -1;

        final Point point = new Point(valueX, valueY);
        final Board board = new Board(sizeField, sizeField);

        final Figure actualFigure = board.getFigure(point);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFiguresNotValidateValueYMoreMax() {
        final int sizeField = 3;
        final int valueX = 0;
        final int valueY = 4;

        final Point point = new Point(valueX, valueY);
        final Board board = new Board(sizeField, sizeField);

        final Figure actualFigure = board.getFigure(point);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFiguresNotValidateValueXAndYLessMin() {
        final int sizeField = 3;
        final int valueX = -1;
        final int valueY = valueX;

        final Point point = new Point(valueX, valueY);
        final Board board = new Board(sizeField, sizeField);

        final Figure actualFigure = board.getFigure(point);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFiguresNotValidateValueXAndYMoreMax() {
        final int sizeField = 3;
        final int valueX = 4;
        final int valueY = valueX;

        final Point point = new Point(valueX, valueY);
        final Board board = new Board(sizeField, sizeField);

        final Figure actualFigure = board.getFigure(point);

        assertNull(actualFigure);
    }

    @Test
    public void testGetSizeX() {
        final int inputSizeX = 3;
        final int exceptedSizeX = inputSizeX;

        final Board board = new Board(inputSizeX, 0);

        final int actualSizeX = board.getSizeFieldX();

        assertEquals(exceptedSizeX, actualSizeX);
    }

    @Test
    public void testGetSizeY() {
        final int inputSizeY = 10;
        final int exceptedSizeY = inputSizeY;

        final Board board = new Board(1, inputSizeY);

        final int actualSizeY = board.getSizeFieldY();

        assertEquals(exceptedSizeY, actualSizeY);
    }
}