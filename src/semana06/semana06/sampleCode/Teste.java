//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package semana06.sampleCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Teste {
    public Teste() {
    }

    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList();
        pessoas.add(new Pessoa("Ana", 60, 165));
        pessoas.add(new Pessoa("Tomas", 70, 165));
        pessoas.add(new Pessoa("Rita", 50, 160));
        pessoas.add(new Pessoa("Bruno", 80, 180));
        pessoas.add(new Pessoa("Joana", 55, 160));
        pessoas.add(new Pessoa("Guilherme", 75, 170));
        pessoas.add(new Pessoa("Vitor", 80, 185));
        pessoas.add(new Pessoa("Pedro", 70, 170));
        pessoas.add(new Pessoa("Vasco", 50, 175));
        List<Pessoa> selecao = select(pessoas, (px) -> {
            return px.getPeso() > 65;
        });
        selecao.forEach((px) -> {
            System.out.println(px);
        });
        List<Integer> lista = new ArrayList();
        Iterator var4 = pessoas.iterator();

        while(var4.hasNext()) {
            Pessoa p = (Pessoa)var4.next();
            lista.add(p.getPeso());
        }

        System.out.println("Media dos pesos: " + average(lista));
    }

    static double average(Iterable<Integer> iterable) {
        double sum = 0.0;
        int count = 0;

        for(Iterator var4 = iterable.iterator(); var4.hasNext(); ++count) {
            int i = (Integer)var4.next();
            sum += (double)i;
        }

        System.out.printf("" + sum + " Count " + count + "\n");
        return sum / (double)count;
    }

    static List<Pessoa> select(List<Pessoa> pessoas, Predicate<Pessoa> pred) {
        List<Pessoa> selecao = new ArrayList();
        Iterator var3 = pessoas.iterator();

        while(var3.hasNext()) {
            Pessoa p = (Pessoa)var3.next();
            if (pred.test(p)) {
                selecao.add(p);
            }
        }

        return selecao;
    }
}
