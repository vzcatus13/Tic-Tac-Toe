package tictactoe;

import java.util.Random;

/**
 * Interface class for Player.
 * @author copycat13
 */
interface Player {
    static Player of(String type) {
        switch (type) {
            case "user": return new Human();
            case "easy": return new EasyAI();
            case "medium": return new MediumAI();
            case "hard": return new HardAI();
            default: return null;
        }
    }

    /**
     * Make a move on specified board.
     * @param board Board on which the move will be performed.
     */
    void move(Board board);


    /**
     * Make a random move on specified board.
     * @param board Board on which the move will be performed.
     */
    default void randomMove(Board board) {
        Random random = new Random();

        int x;
        int y;

        do {
            x = random.nextInt(3) + 1;
            y = random.nextInt(3) + 1;
        } while (!board.isFree(x, y));

        board.setCell(x, y);
    }

    /**
     * Predict on which coordinates specified symbol will win and make move on that coordinates.
     * @param board Board on which the operation will be performed.
     * @param symbol Symbol for which you want to make a move.
     * @return True if move was made, False if move wasn't made.
     */
    default boolean tryToWinSymbol(Board board, Symbol symbol) {
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (board.willWin(i, j, symbol)) {
                    board.setCell(i, j);
                    return true;
                }
            }
        }
        return false;
    }
}
