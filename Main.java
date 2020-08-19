package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command;
        Player[] players = new Player[2];

        do {
            System.out.print("Input command: ");
            command = scanner.nextLine().split(" ");

            if (!"exit".equals(command[0])) {
                if (command.length != 3) {
                    System.out.println("Bad parameters!");
                    continue;
                }
            }

            if ("start".equals(command[0])) {
                players[0] = Player.of(command[1]);
                players[1] = Player.of(command[2]);

                if (players[0] == null || players[1] == null) {
                    System.out.println("Bad parameters!");
                    continue;
                }

                Game game = new Game();
                game.startGame(players[0], players[1]);
                System.out.println("To exit the game input \"exit\"");
            }
        } while (!command[0].equals("exit"));
    }

}
