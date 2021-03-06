package controller;

import exceptions.AlreadyOccupiedException;
import exceptions.InvalidCoordinateException;
import model.Board;
import model.Figure;
import model.Point;

public class MoveController {

    public void applyFigure(final Board board,
                            final Figure figure,
                            final Point point) throws AlreadyOccupiedException, InvalidCoordinateException {


        if (board.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }

        board.setFigures(figure, point);
    }
}
