package viceCity.models.players;

public class CivilPlayer extends BasePlayer {

    private static final int LIFE_POINT = 50;

    //Has 50 initial life points.
    //    //Constructor should take the following values upon initialization:
    public CivilPlayer(String name) {
        super(name, LIFE_POINT);
    }
}
