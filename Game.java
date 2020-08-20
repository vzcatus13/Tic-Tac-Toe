package tictactoe;

import java.util.Scanner;

public class Game {

    private final Board board;

    Scanner scanner = new Scanner(System.in);

    public Game() {
        board = new Board();
    }

    public void startGame(Player playerX, Player playerO) {
        while (gameState() == GameState.UNFINISHED) {
            if (board.chooseSymbol() == Symbol.X) {
                playerX.move(board);
            }
            else {
                playerO.move(board);
            }
            System.out.println(printBoard());
            System.out.println(gameState().getState());
        }
        System.out.println(gameState().getState());
    }

    private GameState gameState() {
        if (board.winner() == Symbol.X) return GameState.X_WIN;
        else if (board.winner() == Symbol.O) return GameState.O_WIN;
        else if (board.winner() == Symbol.EMPTY) return GameState.DRAW;
        else return GameState.UNFINISHED;
    }

    private String printBoard() {
        return board.toString();
    }
}

