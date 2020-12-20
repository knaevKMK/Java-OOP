package viceCity.models.players;

public class MainPlayer extends BasePlayer {
    private static final int LIFE_POINT = 100;
    private static final String NAME = "Tommy Vercetti";
    //Has 100 initial life points and the main player has only one name .
    // The constructor should not take name and life points values upon initialization.

    public MainPlayer() {
        super(NAME, LIFE_POINT);
    }
}
