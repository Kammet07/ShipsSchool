package cz.educanet.praha.pop.battleship;

import java.util.Optional;

public class BattleShip {

    private Field[][] grid = new Field[10][10];
    private Field[][] grid2 = new Field[10][10];
    private FieldHistory[][] history1 = new FieldHistory[10][10];
    private FieldHistory[][] history2 = new FieldHistory[10][10];

    private static void gridSetup(Field[][] grid) {
        //letadlova lod
        grid[0][0] = Field.SHIP_PART;
        grid[0][1] = Field.SHIP_PART;
        grid[0][2] = Field.SHIP_PART;
        grid[0][3] = Field.SHIP_PART;
        grid[0][4] = Field.SHIP_PART;

        //bitevni lod
        grid[5][2] = Field.SHIP_PART;
        grid[6][2] = Field.SHIP_PART;
        grid[7][2] = Field.SHIP_PART;
        grid[8][2] = Field.SHIP_PART;

        //kriznik 1
        grid[3][6] = Field.SHIP_PART;
        grid[4][6] = Field.SHIP_PART;
        grid[5][6] = Field.SHIP_PART;

        //kriznik 2
        grid[7][4] = Field.SHIP_PART;
        grid[8][4] = Field.SHIP_PART;
        grid[9][4] = Field.SHIP_PART;

        //hlidkova lod 1
        grid[8][0] = Field.SHIP_PART;
        grid[9][0] = Field.SHIP_PART;

        //hlidkova lod 2
        grid[1][5] = Field.SHIP_PART;
        grid[1][6] = Field.SHIP_PART;
    }

    public BattleShip() {
        gridSetup(grid);
        gridSetup(grid2);
    }

    public FieldHistory[][] getGrid(Player player) {
        //TODO return history of shots for this player
        return getGridForPlayer(player).clone();
    }

    public TurnResult shoot(int x, int y, Player player) {
        if (!isOnGrid(x, y, player))
            throw new ArrayIndexOutOfBoundsException();

        FieldHistory[][] histories = getGridHistory(player);
        Field[][] grid = getGridForPlayer(player);

        FieldHistory history = histories[y][x];
        if (history != FieldHistory.NONE)
            return history;
        else {
            Field field = grid[y][x];
            grid[y][x] = Field.WATER;
            //TODO save changes to proper history
            return field;
        }
    }


    public Optional<Player> getWinner() {
        if (isWinner(Player.PLAYER1)) return Optional.of(Player.PLAYER1);
        else if (isWinner(Player.PLAYER2)) return Optional.of(Player.PLAYER2);
        else return Optional.empty();
    }

    private boolean isWinner(Player player) {
        Field[][] grid = getGridForPlayer(player);
        for (Field[] row : grid)
            for (Field field : row)
                if (field == Field.SHIP_PART)
                    return false;

        return true;
    }

    public boolean isOnGrid(int x, int y, Player player) {
        Field[][] grid = getGridForPlayer(player);
        return x >= 0 && y >= 0 && grid.length > x && grid[x].length > y;
    }

    /**
     * @return the other player's grid
     */
    private Field[][] getGridForPlayer(Player player) {
        if (player == Player.PLAYER1)
            return grid2;
        else
            return grid;
    }

    /**
     * @return the history of shots
     */
    private FieldHistory[][] getGridHistory(Player player) {
        if (player == Player.PLAYER1)
            return history1;
        else
            return history2;

    }
}
