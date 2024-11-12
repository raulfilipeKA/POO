package semana07.pratica;

public final class Card {

    private static final Card[] cards;

    static{
        cards = new Card[Suit.values().length * Rank.values().length];
        for (int i = 0; i != Suit.values().length ; i++) {
            for (int j = 0; j != Rank.values().length; j++) {

            }
        }
    }

}
