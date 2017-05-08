package controller;

import exceptions.AlreadyOccupiedException;
import exceptions.InvalidCoordinateException;
import model.Board;
import model.Figure;
import model.Point;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class MoveControllerTest {

    @Test
    public void testApplyFigure() throws AlreadyOccupiedException, InvalidCoordinateException {
        final Board board = new Board(3);
        final Figure inputFigure = Figure.O;
        final Figure expectedFigure = inputFigure;
        final Point inputPoint = new Point(0, 0);

        MoveController moveController = new MoveController();

        moveController.applyFigure(board, inputFigure, inputPoint);
        Figure actualFigure = board.getFigure(inputPoint);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void testApplyFigureIsNotSet() throws InvalidCoordinateException {
        final Board board = new Board(3);
        final Point inputPoint = new Point(0, 0);

        Figure actualFigure = board.getFigure(inputPoint);
        assertNull(actualFigure);
    }

    @Test(expected = AlreadyOccupiedException.class)
    public void testApplyFigureWhenPointOccupied() throws InvalidCoordinateException, AlreadyOccupiedException {
        final Board board = new Board(3);
        final Figure inputFigure = Figure.O;
        final Point inputPoint = new Point(0, 0);

        MoveController moveController = new MoveController();

        board.setFigures(inputFigure, inputPoint);
        moveController.applyFigure(board, inputFigure, inputPoint);
    }

    @Test(expected = AlreadyOccupiedException.class)
    public void testApplyFigureWhenPointOccupied2() throws InvalidCoordinateException, AlreadyOccupiedException {
        final Board board = new Board(3);
        final Figure inputFigure = Figure.O;
        final Point inputPoint = new Point(1, 2);

        MoveController moveController = new MoveController();

        board.setFigures(Figure.X, inputPoint);
        moveController.applyFigure(board, inputFigure, inputPoint);
    }
}