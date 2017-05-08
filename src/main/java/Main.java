import controller.GameController;
import model.Board;
import model.Figure;
import model.Player;
import view.ConsoleView;

public class Main {

    public static final int SIZE_FIELD = 3;

    public static void main(String[] args) {
        final Player max = new Player("Max", Figure.X);
        final Player vlad = new Player("Vlad", Figure.O);
        Player[] players = {max, vlad};
        Board board = new Board(SIZE_FIELD);
        GameController gameController = new GameController("XO", board, players);
        ConsoleView view = new ConsoleView(gameController);

        view.showGameNames();
        view.showPlayersName();
        view.showBoard();
        while (view.move()) {
            view.showBoard();
        }
    }
}
