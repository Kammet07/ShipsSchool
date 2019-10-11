package cz.educanet.praha.pop.battleship;

public class BattleShip {

    private Field[][] gameField = new Field[10][10];
    private Field[][] gameField2 = new Field[10][10];

    private static Field[][] gameFieldSetup(Field[][] gameField) {
        //letadlova lod
        gameField[0][0] = Field.SHIP_PART;
        gameField[0][1] = Field.SHIP_PART;
        gameField[0][2] = Field.SHIP_PART;
        gameField[0][3] = Field.SHIP_PART;
        gameField[0][4] = Field.SHIP_PART;

        //bitevni lod
        gameField[5][2] = Field.SHIP_PART;
        gameField[6][2] = Field.SHIP_PART;
        gameField[7][2] = Field.SHIP_PART;
        gameField[8][2] = Field.SHIP_PART;

        //kriznik 1
        gameField[3][6] = Field.SHIP_PART;
        gameField[4][6] = Field.SHIP_PART;
        gameField[5][6] = Field.SHIP_PART;

        //kriznik 2
        gameField[7][4] = Field.SHIP_PART;
        gameField[8][4] = Field.SHIP_PART;
        gameField[9][4] = Field.SHIP_PART;

        //hlidkova lod 1
        gameField[8][0] = Field.SHIP_PART;
        gameField[9][0] = Field.SHIP_PART;

        //hlidkova lod 2
        gameField[1][5] = Field.SHIP_PART;
        gameField[1][6] = Field.SHIP_PART;

        return gameField;
    }

    public BattleShip() {
        gameFieldSetup(gameField);
        gameFieldSetup(gameField2);
    }

    public Field[][] getField(Player player) {
        if (player == Player.PLAYER1)
            return gameField.clone();
        else
            return gameField2.clone();

    }

    public Field play(int x, int y, Player player) {
        try {
            Field hit = gameField[y][x];
            gameField[y][x] = Field.WATER;
            return hit;
        } catch (ArrayIndexOutOfBoundsException ignored) {
            return Field.WATER;
        }
    }
}
