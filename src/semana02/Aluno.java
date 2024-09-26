package semana02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {

	private String nome;
	private int numero;
	
	public Aluno(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}
	
	@Override
	public String toString() {
		return numero + ": " + nome;
	}

	public static ArrayList<Aluno> readAlunos (String path){
		ArrayList<Aluno> alunos = new ArrayList<>();
		try{
			Scanner sc = new Scanner(new File(path));
			while(sc.hasNextLine()){
				String line = sc.nextLine();
				//line.split(" ");
				String[] tokens = line.split(" ", 2);
				int numero = Integer.parseInt(tokens[0]);
				String nome = tokens[1];
				Aluno a = new Aluno (nome, numero);
				alunos.add(a);

			}
			sc.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		return alunos;
	}
	
	
	
}
