package controller;

import model.Player;

public class Game {

    public static final int MIN_COORDINATE = 0;

    public static final int MAX_COORDINATE = 2;

    private final String gameName;

    private Player[] players;

    public Game(String gameName) {
        this.gameName = gameName;
    }

    public Player currentPlayer() {
        return null;
    }

    public boolean move(final int x, final int y) {
        if (!checkCoordinate(x) || !checkCoordinate(y)) {
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

    private static boolean checkCoordinate(final int coordinate) {
        if (coordinate < MIN_COORDINATE || coordinate > MAX_COORDINATE) {
            return false;
        }

        return true;
    }
}
