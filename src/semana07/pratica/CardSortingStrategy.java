package semana07.pratica;

public enum CardSortingStrategy implements java.util.Comparator<Card> {
    BY_SUIT {
        @Override
        public int compare(Card o1, Card o2) {
            return o1.getNaipe().compareTo(o2.getNaipe());
        }
    },
    BY_RANK {
        @Override
        public int compare(Card o1, Card o2) {
            return o1.getValor().compareTo(o2.getValor());
        }
    },
    BY_SUIT_AND_RANK {
        @Override
        public int compare(Card o1, Card o2) {
            if(o1.getNaipe().compareTo(o2.getNaipe()) == 0){
                return o1.getValor().compareTo(o2.getValor());
            }
            return o1.getNaipe().compareTo(o2.getNaipe());
        }
    }



}
