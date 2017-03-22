package view;

import controller.GameController;

public class AdvConsoleView extends ConsoleView {

    public AdvConsoleView(final GameController gameController) {
        super(gameController);
    }

    @Override
    public void showGameNames() {
        System.out.println("***");
        System.out.println(gameController.getGameName());
    }
}
