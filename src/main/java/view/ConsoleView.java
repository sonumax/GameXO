package view;

import controller.GameController;
import controller.MoveController;
import controller.WinnerController;
import exceptions.AlreadyOccupiedException;
import exceptions.InvalidCoordinateException;
import model.Board;
import model.Figure;
import model.Player;
import model.Point;

import java.util.Scanner;

public class ConsoleView {

    public static final String LINE_CHARACTER = "~";
    public static final int LINE_SIZE = 11;

    private final WinnerController winnerController = new WinnerController();
    private final MoveController moveController = new MoveController();
    protected final GameController gameController;


    public ConsoleView(final GameController gameController) {
        assert gameController != null;
        this.gameController = gameController;
    }

    public void showGameNames() {
        System.out.println(gameController.getGameName());
    }

    public void showPlayersName() {
        final int length = gameController.getPlayers().length;
        for (int i = 0; i < length; i++) {
            final Player player = gameController.getPlayers()[i];
            System.out.format("Player %d: %s\n", i + 1, player.getName());
        }
    }

    public boolean move() {
        final Board board = gameController.getBoard();
        final Player currentPlayer = gameController.currentPlayer();
        final Figure winnerFigure = winnerController.getWinner(board);

        if (currentPlayer == null) {
            System.out.format("Not winner!");
            return false;
        }

        final Figure currentFigure = currentPlayer.getFigure();

        if (winnerFigure != null) {
            System.out.format("Winner is %s", findPlayer(winnerFigure).getName());
            return false;
        }

        System.out.format("Please enter move point for: %s(%s)\n", currentPlayer.getName(), currentFigure);
        final Point currentPoint = askPoint();

        try {
            moveController.applyFigure(board, currentFigure, currentPoint);
        } catch (AlreadyOccupiedException | InvalidCoordinateException e) {
            System.out.println("Point is invalid");
        }

        return true;
    }

    public void showBoard() {
        for (int i = 0; i < gameController.getBoard().getSizeBoard(); i++) {
            if(i != 0) {
                showDemarcationLine(LINE_SIZE);
            }
            showBoardLine(i);
        }
    }

    private void showBoardLine(final int column) {
        for (int i = 0; i < gameController.getBoard().getSizeBoard(); i++) {
            if (i != 0) {
                System.out.print("|");
            }
            System.out.print(" ");
            Figure figure = null;
            try {
                figure = gameController.getBoard().getFigure(new Point(i, column));
            } catch (InvalidCoordinateException e) {
                e.printStackTrace();
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void showDemarcationLine(final int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(LINE_CHARACTER);
        }
        System.out.println();
    }

    private Point askPoint() {
        return new Point(askCoordinate() - 1, askCoordinate() - 1);
    }

    private int askCoordinate() {
        final Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    private Player findPlayer(Figure figure) {
        for (Player player : gameController.getPlayers()) {
            if (player.getFigure().equals(figure)) {
                return player;
            }
        }
        return null;
    }
}
