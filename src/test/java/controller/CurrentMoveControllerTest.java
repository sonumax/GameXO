package controller;

import exceptions.InvalidCoordinateException;
import model.Board;
import model.Figure;
import model.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CurrentMoveControllerTest {

    @Test
    public void testCurrentMoveStepO(){
        final Figure expectedFigure = Figure.O;
        Board board = new Board(3, 3);
        CurrentMoveController currentMoveController = new CurrentMoveController();

        try {
            board.setFigures(Figure.X, new Point(1, 1));
            board.setFigures(Figure.O, new Point(2, 1));
            board.setFigures(Figure.X, new Point(0, 1));
        } catch (InvalidCoordinateException e) {
            e.printStackTrace();
        }

        Figure currentFigure = currentMoveController.currentMove(board);

        assertEquals(expectedFigure, currentFigure);
    }

    @Test
    public void testCurrentMoveStepX(){
        final Figure expectedFigure = Figure.X;
        Board board = new Board(3, 3);
        CurrentMoveController currentMoveController = new CurrentMoveController();

        try {
            board.setFigures(Figure.X, new Point(0, 0));
            board.setFigures(Figure.O, new Point(0, 1));
            board.setFigures(Figure.X, new Point(0, 2));
            board.setFigures(Figure.O, new Point(1, 0));
        } catch (InvalidCoordinateException e) {
            e.printStackTrace();
        }

        Figure currentFigure = currentMoveController.currentMove(board);

        assertEquals(expectedFigure, currentFigure);
    }

    @Test
    public void testCurrentMoveAllEmpty() {

        CurrentMoveController currentMoveController = new CurrentMoveController();

        Board board = new Board(3, 3);

        try {
            board.setFigures(Figure.X, new Point(0, 0));
            board.setFigures(Figure.O, new Point(0, 1));
            board.setFigures(Figure.X, new Point(0, 2));
            board.setFigures(Figure.O, new Point(1, 0));
            board.setFigures(Figure.X, new Point(1, 1));
            board.setFigures(Figure.O, new Point(1, 2));
            board.setFigures(Figure.X, new Point(2, 0));
            board.setFigures(Figure.O, new Point(2, 1));
            board.setFigures(Figure.X, new Point(2, 2));
        } catch (InvalidCoordinateException e) {
            e.printStackTrace();
        }

        Figure currentFigure = currentMoveController.currentMove(board);

        assertNull(currentFigure);
    }
}