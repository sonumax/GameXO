package controller;

import model.Board;
import model.Figure;
import model.Point;

import java.util.function.Function;
import java.util.stream.IntStream;

public class CurrentMoveController {

    public Figure currentMove(Board board){
        final Function<Figure, Integer> countCalculator =
                (figure) -> IntStream.range(0, board.getSizeFieldX()).map(row ->
                (int) IntStream.range(0, board.getSizeFieldY()).filter(column ->
                        board.getFigure(new Point(row, column)) != null &&
                                board.getFigure(new Point(row, column)).equals(figure))
                        .count())
                .sum();

        final int countX = countCalculator.apply(Figure.X);
        final int countO = countCalculator.apply(Figure.O);
        final int sumField = countX + countO;

        if (sumField == board.getSizeFieldX() * board.getSizeFieldY()) {
            return null;
        }

        if (countX == countO) {
            return Figure.X;
        } else {
            return Figure.O;
        }
    }
}
