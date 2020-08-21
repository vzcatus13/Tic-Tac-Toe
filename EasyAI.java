package tictactoe;

public class EasyAI implements Player {

    @Override
    public void move(Board board) {
        System.out.println("AI [EASY]: making move...");
        randomMove(board);
    }

}