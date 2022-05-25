package edu.mms.estruturadados.teste;

import edu.mms.estruturadados.model.Contato;
import edu.mms.estruturadados.vetor.VetorObjeto;

public class TesteClasseVetor {

	public static void main(String[] args) {
		
		VetorObjeto vetor = new VetorObjeto(3);		

		Contato c1 = new Contato("Mary", "98641-0067", "jkjrodrigues@hotmail.com");
		Contato c2 = new Contato("Marilainny", "98641-0067", "jkjrodrigues@hotmail.com");
		Contato c3 = new Contato("Lainny", "98641-0067", "jkjrodrigues@hotmail.com");
		Contato c4 = new Contato("Lainny", "98641-0067", "jkjrodrigues@hotmail.com");

		vetor.adiciona(c1);
		vetor.adiciona(c2);
		vetor.adiciona(c3);
		vetor.adiciona(c4);

		System.out.println(vetor);

		int pos = vetor.busca(c3);

		if (pos > -1) {
			System.out.println("elemento existe");  
		} else {
			System.out.println("elemento não existe");   
		}

	}

}
