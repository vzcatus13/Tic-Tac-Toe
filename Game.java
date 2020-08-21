package tictactoe;

import java.util.Scanner;

/**
 * Class represents the Game. Here game starts.
 * @author copycat13
 */
public class Game {

    private final Board board;

    Scanner scanner = new Scanner(System.in);

    /**
     * Create new game with blank board.
     */
    public Game() {
        board = new Board();
    }

    /**
     * Start the game.
     * @param playerX Player who will play for X symbol.
     * @param playerO Player who will play for O symbol.
     */
    public void startGame(Player playerX, Player playerO) {
        while (gameState() == GameState.UNFINISHED) {
            if (board.chooseSymbol() == Symbol.X) {
                playerX.move(board);
            }
            else {
                playerO.move(board);
            }
            System.out.println(printBoard());
        }
        System.out.println(gameState().getState());
    }

    /**
     * Check game state at the moment.
     * @return GameState object.
     */
    private GameState gameState() {
        if (board.winner() == Symbol.X) return GameState.X_WIN;
        else if (board.winner() == Symbol.O) return GameState.O_WIN;
        else if (board.winner() == Symbol.EMPTY) return GameState.DRAW;
        else return GameState.UNFINISHED;
    }

    /**
     * Print board at the moment.
     * @return String object.
     */
    private String printBoard() {
        return board.toString();
    }
}

