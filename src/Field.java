public class Field {
    public char[][] getFieldArr() {
        char[][] field = new char[10][10];

        for (int i = 0; i != 10; i++) {
            for (int y = 0; y != 10; y++) {
                field[i][y] = '-';
            }
        }

        return field;
    }
}
