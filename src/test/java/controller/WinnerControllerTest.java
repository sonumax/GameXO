package controller;

import exceptions.InvalidCoordinateException;
import model.Board;
import model.Figure;
import model.Point;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class WinnerControllerTest {

    @Test
    public void testGetWinnerOnDiagonalOne() {
        final int sizeField = 3;
        final Board board = new Board(sizeField);
        final Figure currentFigure = Figure.X;
        final Figure expectedFigure = currentFigure;

        try {
            board.setFigures(currentFigure, new Point(0, 0));
            board.setFigures(currentFigure, new Point(1, 1));
            board.setFigures(currentFigure, new Point(2, 2));
        } catch (InvalidCoordinateException e) {
            e.printStackTrace();
        }

        WinnerController winnerController = new WinnerController();

        Figure actualFigure = winnerController.getWinner(board);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void testGetWinnerOnDiagonalTwo() throws InvalidCoordinateException {
        final int sizeField = 3;
        final Board board = new Board(sizeField);
        final Figure currentFigure = Figure.X;
        final Figure expectedFigure = currentFigure;

        board.setFigures(currentFigure, new Point(0, 2));
        board.setFigures(currentFigure, new Point(1, 1));
        board.setFigures(currentFigure, new Point(2, 0));

        WinnerController winnerController = new WinnerController();

        Figure actualFigure = winnerController.getWinner(board);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void testGetWinnerOnVertical() throws InvalidCoordinateException {
        final int sizeField = 3;
        final Board board = new Board(sizeField);
        final Figure currentFigure = Figure.X;
        final Figure expectedFigure = currentFigure;

        board.setFigures(currentFigure, new Point(1, 0));
        board.setFigures(currentFigure, new Point(1, 1));
        board.setFigures(currentFigure, new Point(1, 2));

        WinnerController winnerController = new WinnerController();

        Figure actualFigure = winnerController.getWinner(board);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void testGetWinnerOnHorizon() throws InvalidCoordinateException {
        final int sizeField = 3;
        final Board board = new Board(sizeField);
        final Figure currentFigure = Figure.X;
        final Figure expectedFigure = currentFigure;

        board.setFigures(currentFigure, new Point(0, 0));
        board.setFigures(currentFigure, new Point(1, 0));
        board.setFigures(currentFigure, new Point(2, 0));

        WinnerController winnerController = new WinnerController();

        Figure actualFigure = winnerController.getWinner(board);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void testGetWinnerWhereNotWinner() throws InvalidCoordinateException {
        final int sizeField = 3;
        final Board board = new Board(sizeField);
        final Figure currentFigure = Figure.X;

        board.setFigures(currentFigure, new Point(0, 0));
        board.setFigures(currentFigure, new Point(1, 1));
        board.setFigures(currentFigure, new Point(0, 1));

        WinnerController winnerController = new WinnerController();

        Figure actualFigure = winnerController.getWinner(board);

        assertNull(actualFigure);
    }

    @Test
    public void testGetWinnerWhereNotWinnerWithO() throws InvalidCoordinateException {
        final int sizeField = 3;
        final Board board = new Board(sizeField);
        final Figure currentFigure = Figure.X;

        board.setFigures(currentFigure, new Point(0, 0));
        board.setFigures(currentFigure, new Point(1, 1));
        board.setFigures(Figure.O, new Point(2, 2));

        WinnerController winnerController = new WinnerController();

        Figure actualFigure = winnerController.getWinner(board);

        assertNull(actualFigure);
    }
}