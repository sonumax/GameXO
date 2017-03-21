package controller;

import model.Player;

public class Game {

    private static final String GAME_NAME = "XO";

    private Player players[];

    public Player currentPlayer() {
        return null;
    }

    public boolean move(final int x, final int y) {
        return false;
    }

    public static String getGameName() {
        return GAME_NAME;
    }

    public Player[] getPlayers() {
        return players;
    }
}
