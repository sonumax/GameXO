package controller;

import exceptions.AlreadyOccupiedException;
import exceptions.InvalidCoordinateException;
import exceptions.InvalidMoveException;
import model.Board;
import model.Figure;
import model.Point;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.fail;

public class MoveControllerTest {

    @Test
    public void testApplyFigure() {
        final Board board = new Board(3, 3);
        final Figure inputFigure = Figure.O;
        final Figure expectedFigure = inputFigure;
        final Point inputPoint = new Point(0, 0);

        MoveController moveController = new MoveController();

        try {
            moveController.applyFigure(board, inputFigure, inputPoint);
        } catch (InvalidMoveException | AlreadyOccupiedException | InvalidCoordinateException e) {
            e.printStackTrace();
        }

        Figure actualFigure = board.getFigure(inputPoint);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void testApplyFigureIsNotSet() {
        final Board board = new Board(3, 3);
        final Point inputPoint = new Point(0, 0);

        Figure actualFigure = board.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testApplyFigureWhenPointOccupied() {
        final Board board = new Board(3, 3);
        final Figure inputFigure = Figure.O;
        final Point inputPoint = new Point(0, 0);

        MoveController moveController = new MoveController();

        try {
            board.setFigures(Figure.X, inputPoint);
            moveController.applyFigure(board, inputFigure, inputPoint);
            fail();
        } catch (InvalidMoveException | AlreadyOccupiedException | InvalidCoordinateException e) {
        }
    }
}