package cz.educanet.praha.pop.battleship;

public enum Player {
    PLAYER1, PLAYER2;

    public Player other() {
        if (this == PLAYER1)
            return PLAYER2;
        else
            return PLAYER1;
    }
}
