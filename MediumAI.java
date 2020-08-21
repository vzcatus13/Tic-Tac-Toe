package tictactoe;

/**
 * Class which represents medium-level AI.
 * @author copycat13
 */
public class MediumAI implements Player {

    @Override
    public void move(Board board) {
        System.out.println("AI [MEDIUM]: making move...");
        if (tryWin(board)) return;
        if (tryDefend(board)) return;

        randomMove(board);
    }

    /**
     * Try to make a move to win the game.
     * @param board Board on which the operation will be performed.
     * @return True if move was made, False if move wasn't made.
     */
    private boolean tryWin(Board board) {
        Symbol symbol = board.chooseSymbol();
        return tryToWinSymbol(board, symbol);
    }

    /**
     * Try to make a move to the enemy's symbol not to win the game.
     * @param board Board on which the operation will be performed.
     * @return True if move was made, False if move wasn't made.
     */
    private boolean tryDefend(Board board) {
        Symbol symbol = board.chooseSymbol().opposite();
        return tryToWinSymbol(board, symbol);
    }
}
