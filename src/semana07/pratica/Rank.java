package semana07.pratica;

public enum Rank {
    ÀS(11), REI(4), VALETE(3), DAMA(2), DEZ(0), NOVE(0),
    OITO(0), SETE(10), SEIS(0), CINCO(0), QUATRO(0), TRÊS(0), DOIS(0);

    private int i;
    Rank(int i) {
        this.i = i;
    }

    public boolean isInBiscaAndSueca(){
        if(this.equals(DEZ) || this.equals(NOVE) || this.equals(OITO)){
            return false;
        }
        return true;
    }

    public int getPoints() {
        if(!this.isInBiscaAndSueca()){throw new IllegalArgumentException();}
        return i;
    }

    public static void main(String[] args) {
        Rank[] ranks = Rank.values();
        for(Rank rank : ranks){
            System.out.print(rank );
        }
    }

    @Override
    public String toString() {
        return this.name() + " - " + this.i + " ";
    }


}
