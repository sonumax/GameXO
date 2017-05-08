package model;

public class Game {
    private final String name;
    private final Board board;
    private final Player[] players;

    public Game( final String name, final Board board, final Player[] players) {
        this.name = name;
        this.board = board;
        this.players = players;
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
