package tictactoe;

import java.util.Scanner;

/**
 * Class which represents human player.
 * @author copycat13
 */
public class Human implements Player {

    private int x;
    private int y;
    boolean isOperationCompleted;

    Scanner scanner = new Scanner(System.in);

    @Override
    public void move(Board board) {
        do {
            isOperationCompleted = false;
            System.out.print("Enter the coordinates: ");
            String userInput = scanner.nextLine();
            String[] coordinates = userInput.split(" ");

            if (coordinates.length != 2) {
                System.out.println("You should enter two numbers like this: 3 2!");
                continue;
            }

            try {
                x = Integer.parseInt(coordinates[0]);
                y = Integer.parseInt(coordinates[1]);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            isOperationCompleted = board.setCell(x, y);
        }
        while (!isOperationCompleted);
    }
}
