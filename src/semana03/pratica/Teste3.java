package semana03.pratica;

import java.util.ArrayList;

public class Teste3 {
    public static void main(String[] args) {
        String[] palavras = {"casa", "carro", "ave", "cachorro", "LA"};
        ArrayList<String> palavrasList = new ArrayList<>();
        palavrasList.add("casa");
        palavrasList.add("carro");
        palavrasList.add("ave");
        palavrasList.add("cachorro");
        palavrasList.add("LA");

        SeparateBy sepList = new SeparateBy(palavrasList, ", ");
        SeparateBy sep = new SeparateBy(palavras, ", ");


        System.out.println(sepList);
        System.out.println(sep);

    }
}
