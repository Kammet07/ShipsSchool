// From teacher

package battleships;

import java.util.Scanner;

public class Battleships {

    // pole booleanu - boolean znamena, jestli tam je lod, nebo ne
    private boolean[][] field = new boolean[10][10];

    public Battleships() {
        for (int row = 0; row < field.length; row++) {
            for (int column = 0; column < field.length; column++) {
                field[row][column] = false;
            }
        }
        // letadlova lod
        field[0][0] = true;
        field[0][1] = true;
        field[0][2] = true;
        field[0][3] = true;
        field[0][4] = true;

        // Vampiruv kriznik
        field[5][2] = true;
        field[6][2] = true;
        field[7][2] = true;
        field[8][2] = true;

        // Rezlerova jachta1
        field[3][6] = true;
        field[4][6] = true;
        field[5][6] = true;

        // Davidove jachta2
        field[7][4] = true;
        field[8][4] = true;
        field[9][4] = true;

        // Martinuv kajak1
        field[8][0] = true;
        field[9][0] = true;

        // Slowikuv kajak2
        field[7][1] = true;
        field[7][2] = true;
    }

    // zijstuje, jestli vystrel zasahl, nebo ne
    // vraci aktualni stav pole
    public boolean[][] play(int x, int y) {

    }

    public static void main(String[] args) {
        Battleships game = new Battleships();
        Scanner sc = new Scanner(System.in);
        // jeden tah
        while (true) {
            System.out.println("Zadej x");
            int x = sc.nextInt();
            System.out.println("Zadej y");
            int y = sc.nextInt();
            boolean[][] field = game.play(x, y);
            for (int row = 0; row < field.length; row++) {
                System.out.print(row + 1);
                for (int column = 0; column < field[row].length; column++)
                    if (field[row][column] == false)
                        System.out.println("_");
                    else
                        System.out.println("■");
            }

        }
    }

}
