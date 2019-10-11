package cz.educanet.praha.pop.battleship;

import java.util.Scanner;

public class CLI {

    private BattleShip game = new BattleShip();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            printField();
            shoot();
        }
    }

    private void printField() {
        Field[][] gameField = game.getField();

        System.out.print(" ");
        for (int column = 0; column < gameField[0].length; column++) {
            System.out.print(column);
        }

        for (int row = 0; row < gameField.length; row++) {
            int rowLength = gameField[row].length;
            System.out.print(row);
            for (int column = 0; column < rowLength; column++) {
                Field isShipPart = gameField[row][column];
                if (isShipPart == Field.SHIP_PART) {
                    System.out.print("#");
                } else {
                    System.out.println("~");
                }
            }
        }
    }

    private void shoot() {
        int x = sc.nextInt();
        int y = sc.nextInt();

        if (game.play(x, y) == Field.SHIP_PART) {
            System.out.println("Hit!");
        } else {
            System.out.println("Miss!");
        }

    }

    public static void main(String[] args) {
        new CLI().run();
    }
}
