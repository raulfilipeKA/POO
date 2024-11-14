package semana07.pratica;

public final class Card {
    private final Rank valor;
    private final Suit naipe;
    private static final Card[] cards;

    static{
        cards = new Card[Suit.values().length * Rank.values().length];
        int index = 0;
        for (int i = 0; i != Suit.values().length ; i++) {
            for (int j = 0; j != Rank.values().length; j++) {
                cards[index++] = new Card(Suit.values()[i], Rank.values()[j]);
            }
        }
    }

    public static Card getCard( Suit suit, Rank rank){
        for (Card card : cards) {
            if(card.naipe.equals(suit) && card.valor.equals(rank)){
                System.out.println(card);
                return card;
            }
        }
        System.out.println("Carta não encontrada");
        return null;
    }
    Rank getValor(){
        return valor;
    }
    Suit getNaipe(){
        return naipe;
    }

    private Card(Suit suit, Rank rank){
        this.valor= rank;
        naipe = suit;
    }
    public static Card[] getCards(){
        return cards;
    }

    @Override
    public String toString() {
        return valor + " de " + naipe;
    }

    public static void main(String[] args) {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

}
