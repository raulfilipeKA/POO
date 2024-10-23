//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package semana06.sampleCode;

public class Pessoa {
    private String nome;
    private int peso;
    private int altura;

    public Pessoa(String nome, int peso, int altura) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNome() {
        return this.nome;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return this.altura;
    }

    public String toString() {
        return this.nome + " - " + this.peso + " Kg - " + this.altura + " cm";
    }
}
