package controller;

import model.Board;
import model.Figure;
import model.Point;

public class WinnerController {

    public static final int WINNER_COUNT_POINT = 3;
    private int count = 0;

    public Figure getWinner(Board board) {
        //horizon
        for (int i = 0; i < 3; i++) {
            if (checkNextPoint(board, new Point(i, 0), p -> new Point(p.getX(), p.getY() + 1))) {
                return board.getFigure(new Point(i, 0));
            }
        }

        //vertical
        for (int i = 0; i < board.getSizeFieldX(); i++) {
            if (checkNextPoint(board, new Point(0, i), p -> new Point(p.getX() + 1, p.getY()))) {
                return board.getFigure(new Point(0, i));
            }
        }

        //diagonalOne
        if (checkNextPoint(board, new Point(0, 0), p -> new Point(p.getX() + 1, p.getY() + 1))) {
            return board.getFigure(new Point(0, 0));
        }

        //diagonalTwo
        if (checkNextPoint(board, new Point(0, 2), p -> new Point(p.getX() + 1, p.getY() - 1))) {
            return board.getFigure(new Point(0, 2));
        }

        return null;
    }

    private boolean checkNextPoint(final Board board,
                                   final Point point,
                                   final IPointGenerator pointGenerator) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(point);

        count++;
        if (count == WINNER_COUNT_POINT) {
            return true;
        }

        currentFigure = board.getFigure(point);
        nextFigure = board.getFigure(nextPoint);

        if(currentFigure == null || currentFigure != nextFigure) {
            count = 0;
            return false;
        }


        return checkNextPoint(board, nextPoint, pointGenerator);
    }

    private interface IPointGenerator {
        Point next(final Point point);
    }
}
