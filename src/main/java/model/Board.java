package model;

import helpers.CoordinateHelper;

public class Board {

    public static final int SIZE_FIELD = 3;

    private Figure[][] figures = new Figure[SIZE_FIELD][SIZE_FIELD];

    public void initArray() {
        //TODO
    }

    public Figure getFigure(final int x, final int y) {
        if(!CoordinateHelper.checkCoordinate(x) || !CoordinateHelper.checkCoordinate(y)) {
            return null;
        }
        return figures[x][y];
    }
}
