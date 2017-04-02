package model;

public class Game {
    private final Player[] players;
    private final Board board;
    private final String name;

    public Game(final Player[] players, final Board board, final String name) {
        this.players = players;
        this.board = board;
        this.name = name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public String getName() {
        return name;
    }
}
