package edu.mms.estruturadados.colletion;
/*
 * Quando é necessário mantém a ordem dos elementos.
 * Mantém a ordem de inserção dos elementos.
 * É a implementação mais lenta devido manter a ordem.
 */
import java.util.Iterator;

/*
 * Permanece a ordem natural que inseriu os elementos
 * 
 */

import java.util.LinkedHashSet;

public class LinkedHashSetMain {

	public static void main(String[] args) {
		
		LinkedHashSet<Integer> sequenciaNumerica = new LinkedHashSet<>();
		
		//Adicionar os números
		sequenciaNumerica.add(1);
		sequenciaNumerica.add(2);
		sequenciaNumerica.add(8);
		sequenciaNumerica.add(1);
		sequenciaNumerica.add(20);
		sequenciaNumerica.add(14);
		sequenciaNumerica.add(1);
		
		System.out.println(sequenciaNumerica);
		
		//remove o número do set
		sequenciaNumerica.remove(14);
		
		System.out.println(sequenciaNumerica);
		
		//Retornar a quantidade de itens
		System.out.println("tamanho: "+sequenciaNumerica.size());
		
		//Navegar todos os itens iterator
		Iterator<Integer> iterator = sequenciaNumerica.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());		
		}
		
		for(Integer numero : sequenciaNumerica) {
			System.out.println(numero);
		}
		
		//retorna se está vazio
		System.out.println(sequenciaNumerica.isEmpty());

	}

}
