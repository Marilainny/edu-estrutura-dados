package edu.mms.estruturadados.colletion;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ExemploLinkedList {

	public static void main(String[] args) {

		//Primeiro que entra, primeiro que sai.
		Queue<String> filaBanco = new LinkedList<>();

		filaBanco.add("Patricia");
		filaBanco.add("Roberto");
		filaBanco.add("Flávio");
		filaBanco.add("Paulo");
		filaBanco.add("Anderson");
		filaBanco.add("Maria");

		System.out.println(filaBanco);

		//remove o primeiro da fila de atendimento.
		String clienteListaAtendimento = filaBanco.poll(); 

		System.out.println(clienteListaAtendimento);
		System.out.println(filaBanco);

		//Consultar o primeiro da fila de atendimento, sem remover.
		String consultarFilaDeClienteString = filaBanco.peek();

		System.out.println(consultarFilaDeClienteString);
		System.out.println(filaBanco);


		Iterator<String> iteratorFilaBanco = filaBanco.iterator();

		for (String cliente : filaBanco) {
			System.out.println(cliente+"\n");
		}
		while (iteratorFilaBanco.hasNext()) {
			System.out.println("Cliente: "+iteratorFilaBanco.next());
		}

		System.out.println(filaBanco.size());
		System.out.println(filaBanco.isEmpty());
		
		//adicionar mai um elemento vai para o final da fila
		filaBanco.add("Juliana");
		System.out.println(filaBanco);


		///limpar a fila
		filaBanco.clear();
		
		//consultar uma lista caso tiver vazia, vai dar uma exception String
		System.out.println("Vai lançar um erro de exception");
		String consultarContem = filaBanco.element(); System.out.println(consultarContem);

	}

}



