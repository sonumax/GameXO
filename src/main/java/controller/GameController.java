package controller;

import helpers.CoordinateHelper;
import model.Board;
import model.Player;

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
        this.board = board;
        this.players = players;
        if(gameName == null || gameName.isEmpty()) {
            this.gameName = DEFAULT_GAME_NAME;
        } else {
            this.gameName = gameName;
        }
    }

    public Player currentPlayer() {

        final Function<String, Integer> countCalculator = (figure) -> IntStream.range(0, 3).map(row ->
                (int) IntStream.range(0, 3).filter(column ->
                        board.getFigure(row, column) != null &&
                                board.getFigure(row, column).getFigure().equals(figure))
                        .count())
                .sum();

        final int countX = countCalculator.apply("X");
        final int countO = countCalculator.apply("O");

        final boolean xMove = countX == countO;

        if (players[0].getFigure().getFigure().equals("X")) {
            if (xMove) {
                return players[0];
            } else {
                return players[1];
            }
        } else {
            if (xMove) {
                return players[1];
            } else {
                return players[0];
            }
        }
    }

    public Player winner() {

        //horizon
        for (int i = 0; i < 3; i++) {
            if (board.getFigure(i, 0) == board.getFigure(i, 1) &&
                    board.getFigure(i, 0) == board.getFigure(i, 2)) {
                if (players[0].getFigure() == board.getFigure(i, 0)) {
                    return players[0];
                } else {
                    return players[1];
                }
            }
        }

        //vertical
        for (int i = 0; i < 3; i++) {
            if (board.getFigure(0, i) == board.getFigure(1, i) &&
                    board.getFigure(0, i) == board.getFigure(2, i)) {
                if (players[0].getFigure() == board.getFigure(0, i)) {
                    return players[0];
                } else {
                    return players[1];
                }
            }
        }

        //diagonally
        if (board.getFigure(0, 0) == board.getFigure(1, 1) &&
                board.getFigure(0, 0) == board.getFigure(2, 2)) {
            if (players[0].getFigure() == board.getFigure(1, 1)) {
                return players[0];
            } else {
                return players[1];
            }
        }

        if (board.getFigure(0, 2) == board.getFigure(1, 1) &&
                board.getFigure(0, 2) == board.getFigure(2, 0)) {
            if (players[0].getFigure() == board.getFigure(1, 1)) {
                return players[0];
            } else {
                return players[1];
            }
        }

        return null;
    }

    public boolean move(final int x, final int y) {

        if (!CoordinateHelper.checkCoordinate(x) || !CoordinateHelper.checkCoordinate(y)) {
            return false;
        }

        //TODO

        return true;
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
