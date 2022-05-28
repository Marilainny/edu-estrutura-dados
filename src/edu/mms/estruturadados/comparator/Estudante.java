package edu.mms.estruturadados.comparator;
/*
 * Classe Estudante implementa a interface Comparable
 * implementa o método compareTo();
 */
public class Estudante implements Comparable<Estudante> {
	
	private final String nome;
	
	private final Integer idade;

	public Estudante(String nome, Integer idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}

	@Override
	public String toString() {
		return "Estudante [nome=" + nome + ", idade=" + idade + "]";
	}
	/*
	 * Retorna 0 = objeto atual.
	 * -1 ou 1 maior ou menor que o objeto atual. 
	 */
	@Override
	public int compareTo(Estudante o) {
		return this.getIdade() - o.getIdade();
	}
	
	

}
