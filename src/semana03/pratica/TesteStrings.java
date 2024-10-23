package semana03.pratica;
import java.util.ArrayList;
public class TesteStrings {
    public static void main(String[] args) {
        ArrayList<String> palavras = new ArrayList<>();
        palavras.add("casa");
        palavras.add("carro");
        palavras.add("ave");
        palavras.add("cachorro");
        palavras.add("LA");

        System.out.println("Filtrando palavras com menos de 3 letras");
        FilterSmallWords filtro3 = new FilterSmallWords(3);
        //String[] palavrasFiltradas = filtro.filtrar(palavras);

        for (String palavra : palavras) {
            if(filtro3.cumpreOCriterio(palavra)){
                System.out.println(palavra);
            }
        }
        System.out.println("------------------");
        System.out.println("Filtrando palavras que comecam por c");
        FilterWords filtroC = new FilterWords("c");
        for (String palavra : palavras) {
            if(filtroC.cumpreOCriterio(palavra)){
                System.out.println(palavra);
            }
        }

    }
}
