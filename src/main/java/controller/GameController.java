package controller;

import exceptions.InvalidCoordinateException;
import model.Board;
import model.Figure;
import model.Player;
import model.Point;

import java.util.function.Function;
import java.util.stream.IntStream;

public class GameController {

    public static final String DEFAULT_GAME_NAME = "XO";

    private final String gameName;
    private final Board board;
    private final Player[] players;

    public GameController(final String gameName,
                          final Board board,
                          final Player[] players) {
        if(gameName == null || gameName.isEmpty()) {
            this.gameName = DEFAULT_GAME_NAME;
        } else {
            this.gameName = gameName;
        }
        this.board = board;
        this.players = players;
    }

    public Player currentPlayer(){
        final int sizeBoard = board.getSizeBoard();

        final Function<Figure, Integer> countCalculator = (figure) -> IntStream.range(0, sizeBoard).map(row ->
                (int) IntStream.range(0, sizeBoard).filter(column -> {
                    try {
                        return board.getFigure(new Point(row, column)) != null &&
                                board.getFigure(new Point(row, column)).equals(figure);
                    } catch (InvalidCoordinateException e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                        .count())
                .sum();

        final int countX = countCalculator.apply(Figure.X);
        final int countO = countCalculator.apply(Figure.O);

        if (countX + countO == board.getSizeBoard() * board.getSizeBoard()) {
            return null;
        }

        final boolean XMove = countX == countO;

        if (players[0].getFigure().equals(Figure.X)) {
            if (XMove) {
                return players[0];
            } else {
                return players[1];
            }
        } else {
            if (XMove) {
                return players[1];
            } else {
                return players[0];
            }
        }
    }

    public String getGameName() {
        return gameName;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }
}
