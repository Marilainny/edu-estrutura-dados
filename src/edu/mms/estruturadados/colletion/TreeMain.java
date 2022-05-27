package edu.mms.estruturadados.colletion;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeMain {
/*
 * N�o tem uma ordem estabelecida
 * Quando necess�rio altera a ordem atrav�s do uso de comparator
 * Mant�m ordem e pode ser reordenado
 * � perform�tico para leitura.
 * Para modifica��o tem a necessidade de reordenar;
 */
	public static void main(String[] args) {
		
		TreeSet<String> treeCapitais = new TreeSet<>();
		
		treeCapitais.add("Goi�nia");
		treeCapitais.add("S�o Paulo");
		treeCapitais.add("Curitiba");
		treeCapitais.add("Rio de Janeiro");
		treeCapitais.add("Salvador");
		treeCapitais.add("Belo Horizonte");
		
		System.out.println(treeCapitais);
		
		//retorna a primeira capital no topo da �rvore
		System.out.println("Primeiro elemento: "+treeCapitais.first());
		
		//retorna a �ltima capital no final da �rvore
		System.out.println("Ultimo elemento: "+treeCapitais.last());
		
		//retorno parametrizado
		System.out.println(treeCapitais.lower("Rio de Janeiro"));
		
		//retonro parametrizado
		System.out.println(treeCapitais.higher("Salvador"));
		
		//retorna a primeira capital do topo removendo
		System.out.println(treeCapitais.pollFirst());
		
		System.out.println(treeCapitais);
		
		//retorna a ultima capital do topo removendo
		System.out.println(treeCapitais.pollLast());
		
		System.out.println(treeCapitais);
		
		//Navegar em todos os eletementos do iterator
		Iterator<String> iterator = treeCapitais.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}
