package semana02;

import java.util.ArrayList;
import java.util.Scanner;

public class Disciplina {
	
	private String nome;
	private String sigla;
	private int capacidade;

	private ArrayList<Inscricao> inscricoes = new ArrayList<>();
	
	public Disciplina(String nome, String sigla, int capacidade) {
		this.nome = nome;
		this.sigla = sigla;
		this.capacidade = capacidade;
	}

	public static Disciplina criarDisciplina(String nome, int capacidade, ArrayList<Aluno> alunos) {
		String sigla = criarSigla(nome);
		Disciplina disc = new Disciplina(nome, sigla, capacidade);
		for(Aluno aluno : alunos){
			disc.inscrever(aluno);
		}
		return disc; 
	}

	public static String criarSigla(String nome){
		String[] arr = nome.split(" ");
		String sigla = "";
		for (int i = 0; i < arr.length; i++) {
			char letra = arr[i].charAt(0);
			if(!Character.isLowerCase(letra))
				//sigla += (Character.toString(letra));
				sigla += letra;
		}
		return sigla;
	}

	public void inscrever(Aluno aluno) {
		if (inscricoes.size() < capacidade) {
			Inscricao insc = new Inscricao(aluno);
			inscricoes.add(insc);	
		}
		else
			System.err.println("O aluno " + aluno + " já não tem espaço em " + sigla + "...");
	}

	public void desinscrever (int n){
		for( Inscricao insc : inscricoes){
			if(insc.getAluno().getNumero() == n)
				inscricoes.remove(insc);
			else System.err.println("Aluno nao encontrado");
		}
	}
	public void lancarNota( int n, int nota){
		for(Inscricao insc : inscricoes){
			if(insc.getAluno().getNumero() == n)
				insc.setNota(nota);
			else System.err.println("Aluno nao encontrado");
		}
	}
	public boolean temNota(int n){
		for(Inscricao insc : inscricoes){
			if(insc.getAluno().getNumero() == n)
				if(insc.getNota() != -1) return true;
		}
		System.err.println("Aluno nao encontrado");
		return false;
	}

	public int obterNota( int n ) {
		try {
			for (Inscricao insc : inscricoes) {
				if (insc.getAluno().getNumero() == n)
					return insc.getNota();
			}
		} catch (Exception _){
			System.err.println("Aluno nao encontrado");
		}
		return -1;
	}

	public double notaMedia(){
		int sum =0;
		int count=0;
		for(Inscricao insc : inscricoes){
			if(insc.getNota() != -1) {
				sum += insc.getNota();
				count++;
			}
		}
		return (double) (sum / count);
	}

	/*public double notaMedia() {
		double media;
		double[] v = new double[inscricoes.size()];
		for (int i = 0; i < inscricoes.size(); i++) {
			if(inscricoes.get(i).getNota() != -1)
				v[i] = inscricoes.get(i).getNota();
			else v[i] = 0;
		}
		return calcularMedia(v);
	}

	public static double calcularMedia(double[] array) {
		double soma = 0.0;
		for (double valor : array) {
			soma += valor;
		}
		return soma / array.length;
	}
	*/

	@Override
	public String toString() {
		//String aux = nome + " (" + sigla + ") - cap: " + capacidade + "\n";
		String aux = nome + "\n" + capacidade + "\n";
		for (Inscricao insc : inscricoes)
			aux += insc + "\n";
		return aux;
	}


}
