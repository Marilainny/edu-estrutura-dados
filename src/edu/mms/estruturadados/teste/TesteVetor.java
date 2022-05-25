package edu.mms.estruturadados.teste;

import edu.mms.estruturadados.lista.Lista;
import edu.mms.estruturadados.model.Contato;
import edu.mms.estruturadados.vetor.Vetor;

public class TesteVetor {

	public static void main(String[] args) {
		
		Vetor vetor = new Vetor(5);		

		vetor.adiciona("elemento 1");
		vetor.adiciona("elemento 2");
		vetor.adiciona("elemento 3");

		System.out.println(vetor.tamanho());
		System.out.println(vetor);	

		System.out.println(vetor.busca("elemento 4"));

		Lista<Contato> vetorContato = new Lista<Contato>(1);

		Contato c1 = new Contato("Mary", "98641-0067", "jkjrodrigues@hotmail.com");
		Contato c2 = new Contato("Marilainny", "98641-0067", "jkjrodrigues@hotmail.com");
		Contato c3 = new Contato("Lainny", "98641-0067", "jkjrodrigues@hotmail.com");
		Contato c4 = new Contato("Lainny", "98641-0067", "jkjrodrigues@hotmail.com");


		System.out.println(vetorContato);
		System.out.println(vetorContato.contem(c4));

	}

}
