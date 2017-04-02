package model;


import exceptions.InvalidCoordinateException;

public class Board {
    public static final int MIN_COORDINATE = 0;

    private Figure[][] figures;

    public Board(final int sizeFieldX, final int sizeFieldY) {
        figures = new Figure[sizeFieldX][sizeFieldY];
    }

    public Figure getFigure(final Point point ) {
        if(!checkCoordinateX(point.getX()) || !checkCoordinateY(point.getY())) {
            return null;
        }
        return figures[point.getX()][point.getY()];
    }

    public void setFigures(final Figure figure , final Point point) throws InvalidCoordinateException {
        if (!checkCoordinateX(point.getY()) || !checkCoordinateY(point.getY())) {
            throw new InvalidCoordinateException();
        }

        figures[point.getX()][point.getY()] = figure;
    }

    public boolean checkCoordinateX(final int coordinateX) {
        if (coordinateX < MIN_COORDINATE || coordinateX > figures.length) {
            return false;
        }
        return true;
    }

    public boolean checkCoordinateY(final int coordinateY) {
        if (coordinateY < MIN_COORDINATE || coordinateY > figures[0].length) {
            return false;
        }
        return true;
    }

    public int getSizeFieldX() {
        return figures.length;
    }

    public int getSizeFieldY() {
        return figures[0].length;
    }
}
