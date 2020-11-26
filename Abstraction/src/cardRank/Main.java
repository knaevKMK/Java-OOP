package cardRank;


public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        for (int i = 0; i < CardRank.values().length; i++) {
            CardRank card = CardRank.values()[i];
            System.out.println(String.format(
                    "Ordinal value: %d; Name value: %s", card.getOrdinalvalue(), card));
        }
    }
}
