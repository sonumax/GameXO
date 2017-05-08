package model;

import exceptions.InvalidCoordinateException;

public class Board {

    private static final int MIN_COORDINATE = 0;
    private final int maxCoordinate;
    private Figure[][] figures;

    public Board(final int sizeField) {
        figures = new Figure[sizeField][sizeField];
        maxCoordinate = sizeField - 1;
    }

    public Figure getFigure(final Point point) throws InvalidCoordinateException {
        if(!checkCoordinate(point.getX()) || !checkCoordinate(point.getY())) {
            throw new InvalidCoordinateException();
        }
        return figures[point.getX()][point.getY()];
    }

    public void setFigures(final Figure figure , final Point point) throws InvalidCoordinateException {
        if (!checkCoordinate(point.getX()) || !checkCoordinate(point.getY())) {
            throw new InvalidCoordinateException();
        }
        figures[point.getX()][point.getY()] = figure;
    }

    public boolean checkCoordinate(final int coordinate) {
        if (coordinate < MIN_COORDINATE || coordinate > maxCoordinate) {
            return false;
        }
        return true;
    }

    public int getSizeBoard() {
        return figures.length;
    }
}
