package view;

import controller.Game;

public class AdvConsoleView extends GameConsoleView {

    public AdvConsoleView(Game game) {
        super(game);
    }

    @Override
    public void showGameNames() {
        System.out.println("***");
        System.out.println(Game.getGameName());
    }
}
