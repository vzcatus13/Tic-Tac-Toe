package tictactoe;

public class EasyAI implements Player {

    @Override
    public void move(Board board) {
        System.out.println("Making move level \"easy\"");
        randomMove(board);
    }

}