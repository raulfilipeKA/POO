package semana08;

import java.util.PriorityQueue;
import java.util.Queue;

public class HorarioDuvidas {
    Queue<Marcacao> queue = new PriorityQueue<>();

    public static void main(String[] args){
        HorarioDuvidas hd = new HorarioDuvidas();
        hd.marcacao(new Aluno("Ana", 33));
        hd.marcacao(new Aluno("Rui", 12));
        hd.chegada(new Aluno("Joao", 1));
        hd.chegada(new Aluno("Rita", 5));
        hd.chegada(new Aluno("Maria", 2));
        hd.chegada(new Aluno("Pedro", 7));
        hd.chegada(new Aluno("Marta", 4));
        System.out.println(hd.size());
        while(!hd.queue.isEmpty()){
            System.out.println(hd.proximo());
        }
    }

    void marcacao(Aluno a){
        queue.offer(new Marcacao(a, true));
    }

    void chegada(Aluno a){
        queue.offer(new Marcacao(a, false));
    }

    int size() {return queue.size();}

   Marcacao proximo() {
     return queue.poll();
   }



   }


