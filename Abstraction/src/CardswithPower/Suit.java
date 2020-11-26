package CardswithPower;

public enum Suit {

    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int power;

    Suit(int value) {
        this.power = value;
    }

    public int getPower() {
        return power;
    }

}
