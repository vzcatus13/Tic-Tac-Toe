package tictactoe;

public class HardAI implements Player {

    private int x;
    private int y;
    private Symbol[][] board;

    @Override
    public void move(Board board) {
        int bestScore = -10;
        int score;
        this.board = board.getBoard();

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (this.board[3 - j][i - 1] == Symbol.EMPTY) {
                    this.board[3 - j][i - 1] = board.chooseSymbol();
                    score = miniMax(this.board, 0, false, board.chooseSymbol());
                    this.board[3 - j][i - 1] = Symbol.EMPTY;
                    if (score >= bestScore) {
                        bestScore = score;
                        x = i;
                        y = j;
                    }
                }
            }
        }
        board.setCell(x, y);
        System.out.println("Best score: " + bestScore);
        System.out.println("Making move level \"hard\"");
    }

    private int miniMax(Symbol[][] board, int depth, boolean isMaximizing, Symbol whoIsNext) {
        Board tempBoard = new Board(board);
        Symbol winner = tempBoard.winner();
        System.out.println("Minimax:");
        System.out.println(tempBoard.toString());
        if (winner == whoIsNext) return 10;
        else if (winner == whoIsNext.opposite()) return -10;
        else if (winner == Symbol.EMPTY) return 0;

        if (isMaximizing) {
            int bestScore = -10;

            for (int i = 1; i < 4; i++) {
                for (int j = 1; j < 4; j++) {
                    if (board[3 - j][i - 1] == Symbol.EMPTY) {
                        board[3 - j][i - 1] = whoIsNext.opposite();
                        bestScore = Math.min(bestScore, miniMax(board, depth + 1, true, whoIsNext.opposite()));
                        board[3 - j][i - 1] = Symbol.EMPTY;
                    }
                }
            }
            return bestScore;
        }
        else {
            int bestScore = 10;

            for (int i = 1; i < 4; i++) {
                for (int j = 1; j < 4; j++) {
                    if (board[3 - j][i - 1] == Symbol.EMPTY) {
                        board[3 - j][i - 1] = whoIsNext.opposite();
                        bestScore = Math.max(bestScore, miniMax(board, depth + 1, false, whoIsNext.opposite()));
                        board[3 - j][i - 1] = Symbol.EMPTY;
                    }
                }
            }
            return bestScore;
        }
    }
}
