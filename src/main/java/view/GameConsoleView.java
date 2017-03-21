package view;

import controller.Game;
import model.Player;

public class GameConsoleView {

    protected final Game game;

    public GameConsoleView(final Game game) {
        this.game = game;
    }

    public void showGameNames() {
        System.out.println(game.getGameName());
    }

    public void showPlayersName() {
        for (Player player : game.getPlayers()) {
            System.out.println(player.getName());
        }
    }
}
