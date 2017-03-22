package model;

import java.util.Arrays;

public class Board {

    private static final int SIZE_FIELD = 3;

    private Figure[][] figures = new Figure[SIZE_FIELD][SIZE_FIELD];

    public void initArray() {
        //TODO
    }

    public void showBoard() {
        System.out.println(Arrays.deepToString(this.figures));
    }
}
