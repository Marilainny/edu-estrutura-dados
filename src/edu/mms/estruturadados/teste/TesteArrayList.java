package edu.mms.estruturadados.teste;

import edu.mms.estruturadados.lista.Lista;

public class TesteArrayList {

	public static void main(String[] args) {
		
		Lista<String> lista = new Lista <String>(5);

		lista.adiciona("A");
		lista.adiciona("B");
		lista.adiciona("C");
		lista.adiciona("D");

		lista.remove("D");
		System.out.println(lista);
		System.out.println(lista.ultimoIndice("A"));
		System.out.println(lista.obtem(2));


	}

}
