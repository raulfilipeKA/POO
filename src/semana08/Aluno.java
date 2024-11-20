package semana08;

public class Aluno {
    private String nome;
    private int numero;

    public Aluno(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }
    public Aluno(Aluno a) {
        this.nome = a.nome;
        this.numero = a.numero;
    }

    public String getNome() {return nome;}

    public int getNumero() {return numero;}

    @Override
    public String toString() {return "Aluno: " + nome + " Número: " + numero;}

}
