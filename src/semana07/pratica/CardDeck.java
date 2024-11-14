package semana07.pratica;

import java.util.*;
//import java.util.function.Predicate;

public class CardDeck implements Iterable<Card>{
    private List<Card> deck;

    private Card[] cards = Card.getCards();

    public CardDeck(){
        deck = new ArrayList<>();
    }

    public int size(){
        return deck.size();
    }
    public void addCard(Suit s, Rank r){
        deck.add(Card.getCard(s, r));
    }
    public void addCard(Card card){
        deck.add(card);
    }
    public void removeCard(Card card){
        deck.remove(card);
    }
    public void removeCard(Suit s, Rank r){
        deck.remove(Card.getCard(s, r));
    }

    //Criar um molho com todas as cartas, permitindo
    // a utilizacao opcional de um perdicado
    public List<Card> createDeck(java.util.function.Predicate<Card> p){
        Card[] deck = Card.getCards();
        if(p == null) {
            for (Card card : deck) {
                this.deck.add(card);
            }
        } else {
            for (Card card : deck) {
                if (p.test(card)) {
                    this.deck.add(card);
                }
            }
        }
        return this.deck;
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    //ordenar as cartas segundo criterio
    public void sort(Comparator<Card> c){
        deck.sort(c);
    }

    @Override
    public Iterator<Card> iterator() {
        return deck.iterator();
    }


    public static void main(String[] args) {
        System.out.println("1");
        CardDeck deck = new CardDeck();
        System.out.println("2");
        deck.createDeck(null);
        System.out.println("3");
        System.out.println(deck.size());
        deck.shuffle();
        for (Card card : deck) {
            System.out.println(card);
        }
        System.out.println("--------------------");
        deck.sort(CardSortingStrategy.BY_RANK);
        for (Card card : deck) {
            System.out.println(card);
        }
        System.out.println("--------------------");
        deck.sort(CardSortingStrategy.BY_SUIT);
        for (Card card : deck) {
            System.out.println(card);
        }
        System.out.println("--------------------");
        deck.sort(CardSortingStrategy.BY_SUIT_AND_RANK);
        for (Card card : deck) {
            System.out.println(card);
        }
        System.out.println("--------------------");
        deck.createDeck(card -> card.getValor() != Rank.NOVE && card.getValor() != Rank.OITO && card.getValor() != Rank.DEZ);
        for (Card card : deck) {
            System.out.println(card);
        }
    }


}
