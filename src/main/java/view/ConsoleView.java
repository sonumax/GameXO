package view;

import controller.GameController;
import model.Board;
import model.Player;

public class ConsoleView {

    public static final String LINE_CHARACTER = "~";

    public static final int LINE_SIZE = 15;

    protected final GameController gameController;

    public ConsoleView(final GameController gameController) {
        assert gameController != null;
        this.gameController = gameController;
    }

    public void showGameNames() {
        System.out.println(gameController.getGameName());
    }

    public void showPlayersName() {
        for (Player player : gameController.getPlayers()) {
            System.out.println(player.getName());
        }
    }

    public void showBoard() {
        for (int i = 0; i < Board.SIZE_FIELD; i++) {
            showBoardLine(i);
            showDemarcationLine(LINE_SIZE);
        }
    }

    private void showBoardLine(final int row) {
        for (int i = 0; i < Board.SIZE_FIELD; i++) {
            System.out.println(gameController.getBoard().getFigure(row, i));
        }
        System.out.println();
    }

    private void showDemarcationLine(final int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(LINE_CHARACTER);
        }
        System.out.println();
    }


}
