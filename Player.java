package tictactoe;

import java.util.Random;

interface Player {
    static Player of(String type) {
        switch (type) {
            case "user": return new Human();
            case "easy": return new EasyAI();
            case "medium": return new MediumAI();
            default: return null;
        }
    }

    void move(Board board);

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
