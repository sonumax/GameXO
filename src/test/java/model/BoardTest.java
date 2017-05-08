package model;

import exceptions.InvalidCoordinateException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    @Test
    public void testSetFigures() throws InvalidCoordinateException {
        final int sizeField = 3;
        final int valueX = 0;
        final int valueY = valueX;

        final Point point = new Point(valueX, valueY);
        final Figure inputFigure = Figure.X;
        final Figure expectedFigure = inputFigure;
        final Board board = new Board(sizeField);

        board.setFigures(inputFigure, point);
        Figure actualFigure = board.getFigure(point);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test(expected = InvalidCoordinateException.class)
    public void testSetFiguresWithInvalidCoordinate() throws InvalidCoordinateException {
        final int sizeField = 3;
        final int valueX = -1;
        final int valueY = valueX;

        final Point point = new Point(valueX, valueY);
        final Figure inputFigure = Figure.X;
        final Board board = new Board(sizeField);

        board.setFigures(inputFigure, point);
    }

    @Test(expected = InvalidCoordinateException.class)
    public void testGetFiguresNotValidateValueXLessMin() throws InvalidCoordinateException {
        final int sizeField = 3;
        final int valueX = -1;
        final int valueY = 0;

        final Point point = new Point(valueX, valueY);
        final Board board = new Board(sizeField);

        final Figure actualFigure = board.getFigure(point);
    }

    @Test(expected = InvalidCoordinateException.class)
    public void testGetFiguresNotValidateValueXMoreMax() throws InvalidCoordinateException {
        final int sizeField = 3;
        final int valueX = 4;
        final int valueY = 0;

        final Point point = new Point(valueX, valueY);
        final Board board = new Board(sizeField);

        final Figure actualFigure = board.getFigure(point);

    }

    @Test(expected = InvalidCoordinateException.class)
    public void testGetFiguresNotValidateValueYLessMin() throws InvalidCoordinateException {
        final int sizeField = 3;
        final int valueX = 0;
        final int valueY = -1;

        final Point point = new Point(valueX, valueY);
        final Board board = new Board(sizeField);

        final Figure actualFigure = board.getFigure(point);
    }

    @Test(expected = InvalidCoordinateException.class)
    public void testGetFiguresNotValidateValueYMoreMax() throws InvalidCoordinateException {
        final int sizeField = 3;
        final int valueX = 0;
        final int valueY = 4;

        final Point point = new Point(valueX, valueY);
        final Board board = new Board(sizeField);

        final Figure actualFigure = board.getFigure(point);
    }

    @Test(expected = InvalidCoordinateException.class)
    public void testGetFiguresNotValidateValueXAndYLessMin() throws InvalidCoordinateException {
        final int sizeField = 3;
        final int valueX = -1;
        final int valueY = valueX;

        final Point point = new Point(valueX, valueY);
        final Board board = new Board(sizeField);

        final Figure actualFigure = board.getFigure(point);
    }

    @Test(expected = InvalidCoordinateException.class)
    public void testGetFiguresNotValidateValueXAndYMoreMax() throws InvalidCoordinateException {
        final int sizeField = 3;
        final int valueX = 4;
        final int valueY = valueX;

        final Point point = new Point(valueX, valueY);
        final Board board = new Board(sizeField);

        final Figure actualFigure = board.getFigure(point);
    }

    @Test
    public void testGetSize() {
        final int inputSize = 3;
        final int exceptedSize = inputSize;

        final Board board = new Board(inputSize);

        final int actualSize = board.getSizeBoard();

        assertEquals(exceptedSize, actualSize);
    }
}