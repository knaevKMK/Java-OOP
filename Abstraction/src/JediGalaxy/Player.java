package JediGalaxy;

public class Player {
    private long score;

    public Player() {
        this.score = 0;
    }

    public long getScore() {
        return this.score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "" + this.score;
    }
}
