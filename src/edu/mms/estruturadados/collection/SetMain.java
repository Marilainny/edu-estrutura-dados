package edu.mms.estruturadados.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * N�o garante a ordem dos itens.
 * N�o permite item repetido.
 * N�o possui busca por item e atualiza��o. Apenas navega��o.
 * N�o permite mudan�a de ordena��o.
 * Mais perfomatica
 */
public class SetMain {
	
	public static void main(String[] args) {
		
		Set<Double> notasAlunos = new HashSet<>();
		
		notasAlunos.add(5.8);
		notasAlunos.add(9.3);
		notasAlunos.add(6.5);
		notasAlunos.add(5.4);
		notasAlunos.add(10.0);
		notasAlunos.add(7.8);
		notasAlunos.add(7.3);
		notasAlunos.add(4.0);
		
		System.out.println(notasAlunos);
		
		//remover elemento
		notasAlunos.remove(5.4);
		
		System.out.println("notas: "+notasAlunos);
		
		//Retornar tamanho
		System.out.println("Tamanho: "+notasAlunos.size());
		
		//Navegar em todos os elementos do iterator
		Iterator<Double>iterator = notasAlunos.iterator();
		
		while (iterator.hasNext()){			
			System.out.println(iterator.next());			
		}
		
		for (Double nota : notasAlunos) {
			System.out.println("nota: "+nota);
		}
		
		//limpar
		notasAlunos.clear();
		
		//Retorna se est� vazio
		System.out.println("vazio: "+notasAlunos.isEmpty());		
				
	}

}
