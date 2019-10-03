public class Ships {
    public static void main(String[] args) {
        Field fd = new Field();

        char[][] field = fd.getFieldArr();

        for (int i = 0; i != 10; i++) {
            System.out.println(field[i]);
        }
    }
}
