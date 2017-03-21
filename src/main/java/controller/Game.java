package controller;

import model.Player;

public class Game {

    private final String gameName;

    private Player[] players;

    public Game(final String gameName) {
        this.gameName = gameName;
    }

    public Player currentPlayer() {
        return null;
    }

    public boolean move(final int x, final int y) {
        return false;
    }

    public String getGameName() {
        return gameName;
    }

    public Player[] getPlayers() {
        return players;
    }
}
