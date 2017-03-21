package view;

import controller.Game;
import model.Player;

public class GameConsoleView {

    protected final Game game;

    public GameConsoleView(Game game) {
        this.game = game;
    }

    public void showGameNames() {
        System.out.println(Game.getGameName());
    }

    public void showPlayersName() {
        for (Player player : game.getPlayers()) {
            System.out.println(player.getName());
        }
    }
}
