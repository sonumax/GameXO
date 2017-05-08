package model;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class GameTest {

    @Test
    public void testGetPlayers() {
        final Player[] inputPlayers = new Player[] {new Player("Max", Figure.O), new Player("Vlad", Figure.X)};
        final Player[] exceptedPlayers = inputPlayers;

        Game game = new Game(null, null, inputPlayers);

        final Player[] actualPlayer = game.getPlayers();

        assertEquals(exceptedPlayers, actualPlayer);
    }

    @Test
    public void testGetBoard() {
        final Board inputBoard = new Board(3);
        final Board exceptedBoard = inputBoard;

        Game game = new Game(null, inputBoard, null);

        final Board actualBoard = game.getBoard();

        assertEquals(exceptedBoard, actualBoard);
    }

    @Test
    public void testGetName() {
        final String inputName = "Name";
        final String exceptedName = inputName;

        Game game = new Game(inputName, null, null);

        final String actualName = game.getName();

        assertEquals(exceptedName, actualName);
    }
}