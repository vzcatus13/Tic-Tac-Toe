package tictactoe;

public class MediumAI implements Player {

    @Override
    public void move(Board board) {
        System.out.println("Making move level \"medium\"");
        if (tryWin(board)) return;
        if (tryDefend(board)) return;

        randomMove(board);
    }

    private boolean tryWin(Board board) {
        Symbol symbol = board.chooseSymbol();
        return tryToWinSymbol(board, symbol);
    }

    private boolean tryDefend(Board board) {
        Symbol symbol = board.chooseSymbol().opposite();
        return tryToWinSymbol(board, symbol);
    }
}
