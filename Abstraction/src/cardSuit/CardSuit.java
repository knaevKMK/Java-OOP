package cardSuit;

public enum CardSuit {

    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);

    private int ordinalValue;

     CardSuit(int value) {
        this.ordinalValue = value;
    }
    public int getValue() {
        return ordinalValue;
    }


}
