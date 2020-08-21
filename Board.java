package tictactoe;

/**
 * Class which represents 3x3 board.
 * @author copycat13
 */
class Board {

    private final Symbol[][] board;
    private boolean xIsNext;

    /**
     * Create new blank board, where X symbol plays first.
     */
    public Board() {
        board = new Symbol[][] {
                {Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY},
                {Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY},
                {Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY}
        };
        xIsNext = true;
    }

    /**
     * Create Board object from existing board
     * @param board Existing board, which is two-dimensional Symbol object array.
     */
    public Board(Symbol[][] board) {
        this.board = board;
    }

    /**
     * Set point on the board.
     * @param x First coordinate of the point.
     * @param y Second coordinate of the point.
     * @return True if point was set on the board, False if wasn't set.
     */
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

    /**
     * Unset point on the board.
     * @param x First coordinate of the point.
     * @param y Second coordinate of the point.
     */
    void unSetCell(int x, int y) {
        if (x < 0 || y < 0 || x > 3 || y > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
        }

        board[3 - y][x - 1] = Symbol.EMPTY;
        xIsNext = !xIsNext;
    }

    /**
     * Choose symbol which will move next.
     * @return Symbol which will move next.
     */
    Symbol chooseSymbol() {
        return xIsNext ? Symbol.X : Symbol.O;
    }

    /**
     * Check if specified point is free for set.
     * @param x First coordinate of the point.
     * @param y Second coordinate of the point.
     * @return True if specified point is free, False if occupied.
     */
    boolean isFree(int x, int y) {
        return board[3 - y][x - 1] == Symbol.EMPTY;
    }

    /**
     * Check if board is full and there is not free points to set.
     * @return True if board is full, False if there is free space.
     */
    boolean isFull() {
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (isFree(i, j)) return false;
            }
        }
        return true;
    }

    /**
     * Check which symbol is winner
     * @return Symbol of winner if there is, if there isn't return empty symbol.
     */
    Symbol winner() {
        if (winnerInDiagonal(Symbol.X) || winnerInRow(Symbol.X) || winnerInColumn(Symbol.X)) return Symbol.X;
        else if (winnerInDiagonal(Symbol.O) || winnerInRow(Symbol.O) || winnerInColumn(Symbol.O)) return Symbol.O;
        else if (isFull()) return Symbol.EMPTY;
        return null;
    }

    /**
     * Predict if specified symbol will win on specified point.
     * @param x First coordinate of the point
     * @param y Second coordinate of the point.
     * @param symbol Symbol for prediction.
     * @return True if specified symbol will win on specified point, False if will not.
     */
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

    /**
     * Check winner in diagonal.
     * @param symbol Symbol to check for win.
     * @return True if specified symbol won, False if didn't.
     */
    private boolean winnerInDiagonal(Symbol symbol) {
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) return true;
        else if (board[2][0] == symbol && board[1][1] == symbol && board[0][2] == symbol) return true;
        return false;
    }

    /**
     * Check winner in row.
     * @param symbol Symbol to check for win.
     * @return True if specified symbol won, False if didn't.
     */
    private boolean winnerInRow(Symbol symbol) {
        for (Symbol[] symbols : board) {
            if (symbols[0] == symbol && symbols[1] == symbol && symbols[2] == symbol) return true;
        }
        return false;
    }

    /**
     * Check winner in column.
     * @param symbol Symbol to check for win.
     * @return True if specified symbol won, False if didn't.
     */
    private boolean winnerInColumn(Symbol symbol) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) return true;
        }
        return false;
    }

    /**
     * Get two-dimensional Symbol object array, which represents board.
     * @return two-dimensional Symbol object array.
     */
    Symbol[][] getBoard() {
        return board;
    }

    /**
     * Get String representation of board.
     * @return String object representation of board.
     */
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
