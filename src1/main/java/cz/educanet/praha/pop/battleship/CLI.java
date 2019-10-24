package cz.educanet.praha.pop.battleship;

import java.util.Scanner;

public class CLI {

    private BattleShip game = new BattleShip();
    private Scanner sc = new Scanner(System.in);
    private int roundNumb = 0;

    public void run() {
        printRulesAndInstructions();
        while (true) {
            printField();
            shoot();
        }
    }

    private void printRulesAndInstructions() {
        System.out.println("instrukce");
    }

    private Player getWhichPlayer() {
        int playerInt = (roundNumb % 2) + 1;
        System.out.println("Cislo hrace  " +playerInt);
        if (playerInt == 1) {
            return Player.PLAYER1;
        } else {
            return Player.PLAYER2;
        }
    }

    private void printField() {
        Field[][] gameField = game.getField(getWhichPlayer());

        System.out.print(" ");
        for (int column = 0; column < gameField[0].length; column++) {
            System.out.print(column + " ");
        }
        System.err.print("X");

        for (int row = 0; row < gameField.length; row++) {
            int rowLength = gameField[row].length;

            System.out.println("");
            System.out.print(row);
            for (int column = 0; column < rowLength; column++) {
                Field isShipPart = gameField[row][column];
                if (isShipPart == Field.SHIP_PART) {
                    System.out.print("⛵ ");
                } else {
                    System.out.print("🌊 ");
                }
            }
        }
        System.out.println("\nY");
    }

    private void shoot() {
        this.roundNumb++;

        System.out.println("Cislo roundu " + roundNumb);

        System.out.println("Zadej X");
        int x = sc.nextInt();
        System.out.println("Zadej Y");
        int y = sc.nextInt();

        if (game.play(x, y, getWhichPlayer()) == Field.SHIP_PART) {
            System.out.println("Hit!");
        } else {
            System.out.println("Miss!");
        }

    }

    public static void main(String[] args) {
        new CLI().run();
    }
}
