package JediGalaxy;

public class Game {
    private int[][] desk;
    private Player player;

    public Game(int []i) {
        this.desk = new int[i[0]][i[1]];
        this.player = (new Player());
        fillDesk();

    }

    public Player getPlayer() {
        return player;
    }

    public void setEvil(int row, int col) {
        if (row < 0 || col < 0) {
            return;
        }
        if (row < desk.length && col < desk[row].length) {
            this.desk[row][col] = 0;
        }
        setEvil(row - 1, col - 1);
    }

    public void play(int row, int coll) {
        long sum = this.player.getScore();
        while (row >= 0 && coll < desk[1].length) {
            if (row < desk.length && coll >= 0 && coll < desk[row].length) {
                sum += desk[row][coll];
            }
            coll++;
            row--;
        }
        this.player.setScore(sum);
    }

    private void fillDesk() {
        int c = 0;
        for (int i = 0; i < this.desk.length; i++) {
            for (int j = 0; j < this.desk[i].length; j++) {
                this.desk[i][j] = c++;
            }
        }
    }


}
