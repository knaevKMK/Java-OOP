package CardswithPower;

public class Card {
    private Suit suit;
    private Rank rank;
    private int power;

    public Card(String... s) {
        this.rank = Rank.valueOf(s[0].toUpperCase());
        this.suit = Suit.valueOf(s[1].toUpperCase());
        this.power = rank.getPower() + suit.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %s", this.rank, this.suit, this.power);
    }
}
