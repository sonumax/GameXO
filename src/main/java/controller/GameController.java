package controller;

import helpers.CoordinateHelper;
import model.Board;
import model.Player;

public class GameController {

    private final String gameName;

    private final Board board;

    private final Player[] players;

    public GameController(final String gameName, final Board board, final Player[] players) {
        this.board = board;
        this.players = players;
        if(gameName == null || gameName.isEmpty()) {
            this.gameName = "XO";
        } else {
            this.gameName = gameName;
        }
    }

    public Player currentPlayer() {
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
