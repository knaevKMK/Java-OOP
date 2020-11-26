package rhombus;

public class Rombus {
    private int size;
    private StringBuilder shape;

    public Rombus(int size) {
        this.size = size;
        this.shape = new StringBuilder();
    }

    public void create() {
        createTop();
        createBottom();
    }

    private void createTop() {
        for (int i = 1; i <= size; i++) {
            createRow(" ", size - i);
            createRow("* ", i);
            System.out.println();
        }
    }

    private void createBottom() {
        for (int i = 1; i <= size - 1; i++) {
            createRow(" ", i);
            createRow("* ", size - i);
            System.out.println();
        }
    }

    private void createRow(String s, int row) {
        for (int j = 1; j <= row; j++) {
            System.out.print(s);
        }
    }
}
