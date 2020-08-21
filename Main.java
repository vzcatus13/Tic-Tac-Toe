package tictactoe;

import java.util.Scanner;

/**
 * This is a Main class of Game where user's commands are processing.
 * @author copycat13
 */


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command;
        Player[] players = new Player[2];

        do {
            System.out.print("Input command: ");
            command = scanner.nextLine().split(" ");

            if ("exit".equals(command[0].toLowerCase())) {
                break;
            }


            if ("start".equals(command[0].toLowerCase())) {
                if (command.length != 3) {
                    System.out.println("Bad parameters!\nCorrect input: START [MODE] [MODE]");
                    continue;
                }
                players[0] = Player.of(command[1].toLowerCase());
                players[1] = Player.of(command[2].toLowerCase());

                if (players[0] == null || players[1] == null) {
                    System.out.println("Bad parameters: input correct players!\nExample: START USER MEDIUM");
                    continue;
                }

                Game game = new Game();
                game.startGame(players[0], players[1]);
                System.out.println("To exit the game input EXIT");
                continue;
            }


            if ("help".equals(command[0].toLowerCase())) {
                System.out.println("START [MODE] [MODE]\tstart the game.\n  MODE: USER, EASY, MEDIUM, HARD");
                System.out.println("EXIT\texit the game");
                continue;
            }

            System.out.println("Incorrect command. List of commands: HELP");
        } while (true);
    }

}
