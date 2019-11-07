package cz.educanet.praha.pop.battleship;

import java.util.Optional;
import java.util.Scanner;

public class CLI {

    private BattleShip game = new BattleShip();
    private Scanner sc = new Scanner(System.in);

    private Player currentPlayer = Player.PLAYER1;

    public void run() {
        Optional<Player> winner = game.getWinner();
        while (!winner.isPresent()) {
            printField();
            shoot();
            currentPlayer = currentPlayer.other();
            winner = game.getWinner();
        }
        String playerName = getPlayerName(winner.get());
        System.out.println("Winner: " + playerName);
    }

    private void printField() {
        FieldHistory[][] grid = game.getGrid(currentPlayer.other());

        System.out.println();
        System.out.print(" ");
        for (int column = 0; column < grid[0].length; column++)
            System.out.print(column);


        System.out.println();
        for (int row = 0; row < grid.length; row++) {
            int rowLength = grid[row].length;
            System.out.print(row);
            for (int column = 0; column < rowLength; column++) {
                Field field = grid[row][column];
                //TODO print "nothing" or previous miss/hit
            }
            System.out.println();
        }
    }

    private void shoot() {
        String playerName = getPlayerName(currentPlayer);
        System.out.println(playerName + "'s turn");

        boolean successfullyTurned = false;
        do {
            System.out.print("Enter X:");
            int x = sc.nextInt();
            System.out.print("Enter Y:");
            int y = sc.nextInt();

            if (game.isOnGrid(x, y, currentPlayer)) {
                if (game.shoot(x, y, currentPlayer) == FieldHistory.NONE) //TODO fix
                    System.out.println("Hit!");
                else
                    System.out.println("Miss!");
                successfullyTurned = true;
            } else {
                System.out.println("Invalid coordinates.");
            }
        } while (!successfullyTurned);
    }

    private String getPlayerName(Player player) {
        if (player == Player.PLAYER1)
            return "Player 1";
        else return "Player 2";
    }

    public static void main(String[] args) {
        new CLI().run();
    }
}
