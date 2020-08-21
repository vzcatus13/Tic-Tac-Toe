package tictactoe;

/**
 * Class which represents hard-level AI.
 * @author copycat13
 */
public class HardAI implements Player {

    private int x;
    private int y;
    private Symbol[][] board;

    @Override
    public void move(Board board) {
        boolean isMaximizing = board.chooseSymbol() == Symbol.X;

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            int score;
            for (int i = 1; i < 4; i++) {
                for (int j = 1; j < 4; j++) {
                    if (board.isFree(i, j)) {
                        board.setCell(i, j);
                        score = minimax(board, false);
                        board.unSetCell(i, j);
                        if (score > bestScore) {
                            bestScore = score;
                            x = i;
                            y = j;
                        }
                    }
                }
            }
        }
        else {
            int bestScore = Integer.MAX_VALUE;
            int score;
            for (int i = 1; i < 4; i++) {
                for (int j = 1; j < 4; j++) {
                    if (board.isFree(i, j)) {
                        board.setCell(i, j);
                        score = minimax(board, true);
                        board.unSetCell(i, j);
                        if (score < bestScore) {
                            bestScore = score;
                            x = i;
                            y = j;
                        }
                    }
                }
            }
        }

        board.setCell(x, y);
        System.out.println("AI [HARD]: making move...");
    }

    /**
     * minimax algorithm implementation
     * @param board Board on which the operation will be performed.
     * @param isMaximizing boolean which specifies if we try to maximize score.
     * @return the best score for specified Board.
     */
    private int minimax(Board board, boolean isMaximizing) {
        Symbol winner = board.winner();

        if (winner == Symbol.X) return 1;
        else if (winner == Symbol.O) return -1;
        else if (winner == Symbol.EMPTY) return 0;

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            int score;

            for (int i = 1; i < 4; i++) {
                for (int j = 1; j < 4; j++) {
                    if (board.isFree(i, j)) {
                        board.setCell(i, j);
                        score = minimax(board, false);
                        bestScore = Math.max(score, bestScore);
                        board.unSetCell(i, j);
                    }
                }
            }
            return bestScore;
        }
        else {
            int bestScore = Integer.MAX_VALUE;
            int score;

            for (int i = 1; i < 4; i++) {
                for (int j = 1; j < 4; j++) {
                    if (board.isFree(i, j)) {
                        board.setCell(i, j);
                        score = minimax(board, true);
                        bestScore = Math.min(score, bestScore);
                        board.unSetCell(i, j);
                    }
                }
            }
            return bestScore;
        }
    }
}
