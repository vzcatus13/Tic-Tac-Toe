package tictactoe;

import java.util.Scanner;

class Board {

    private final Symbol[][] board;
    private boolean xIsNext;

    public Board() {
        board = new Symbol[][] {
                {Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY},
                {Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY},
                {Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY}
        };
        xIsNext = true;
    }

    public Board(Symbol[][] board) {
        this.board = board;
    }


    public boolean setCell(int x, int y) {

        if (x < 0 || y < 0 || x > 3 || y > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        if (!isFree(x, y)) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

        board[3 - y][x - 1] = chooseSymbol();
        xIsNext = !xIsNext;

        return true;
    }

    void unSetCell(int x, int y) {
        if (x < 0 || y < 0 || x > 3 || y > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
        }

        board[3 - y][x - 1] = Symbol.EMPTY;
        xIsNext = !xIsNext;
    }

    Symbol chooseSymbol() {
        return xIsNext ? Symbol.X : Symbol.O;
    }

    boolean isFree(int x, int y) {
        return board[3 - y][x - 1] == Symbol.EMPTY;
    }

    boolean isFull() {
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (isFree(i, j)) return false;
            }
        }
        return true;
    }

    Symbol winner() {
        if (winnerInDiagonal(Symbol.X) || winnerInRow(Symbol.X) || winnerInColumn(Symbol.X)) return Symbol.X;
        else if (winnerInDiagonal(Symbol.O) || winnerInRow(Symbol.O) || winnerInColumn(Symbol.O)) return Symbol.O;
        else if (isFull()) return Symbol.EMPTY;
        return null;
    }

    boolean willWin(int x, int y, Symbol symbol) {

        if (isFree(x, y)) {
            Symbol before = board[3 - y][x - 1];
            board[3 - y][x - 1] = symbol;

            boolean won = winner() == symbol;

            board[3 - y][x - 1] = before;
            return won;
        }
        return false;
    }

    private boolean winnerInDiagonal(Symbol symbol) {
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) return true;
        else if (board[2][0] == symbol && board[1][1] == symbol && board[0][2] == symbol) return true;
        return false;
    }


    private boolean winnerInRow(Symbol symbol) {
        for (Symbol[] symbols : board) {
            if (symbols[0] == symbol && symbols[1] == symbol && symbols[2] == symbol) return true;
        }
        return false;
    }


    private boolean winnerInColumn(Symbol symbol) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) return true;
        }
        return false;
    }

    Symbol[][] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("---------\n");
        for (Symbol[] symbols : board) {
            output.append("|");
            for (Symbol aSymbol : symbols) {
                output.append(" ").append(aSymbol.getSymbol());
            }
            output.append(" |\n");
        }
        output.append("---------");
        return output.toString();
    }
}
