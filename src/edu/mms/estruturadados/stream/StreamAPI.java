package edu.mms.estruturadados.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * Manipulação de coleção com paradigma funcional de forma paralela.
 * imutável, não altera a coleção origem, sempre cria uma nova coleção.
 * 
 */
public class StreamAPI {

	public static void main(String[] args) {
			
		//coleção de String
		List<String> estudantes = new ArrayList<>();
		
		estudantes.add("Carlos");
		estudantes.add("Lucia");
		estudantes.add("Mariza");
		estudantes.add("Tulio");
		estudantes.add("Sandro");
		estudantes.add("Paula");
		
		//retorna a contagem de stream
		System.out.println("contagem: "+estudantes.stream().count());
		
		//retorna o elemento com mais número de letras
		System.out.println("maior número de letras "+estudantes.stream().max(Comparator.comparingInt(String::length)));
		
		//retorna o elemento com menor número de letras
		System.out.println("menor número de letras "+estudantes.stream().min(Comparator.comparingInt(String::length)));
		
		//retorna a letra do elemento
		System.out.println("com a letra R no nome: " +estudantes.stream().filter((estudante) -> 
				estudante.toLowerCase().contains("r")).collect(Collectors.toList()));
		
		//retorna uma nova coleção
		System.out.println("nova coleção "+estudantes.stream().map(estudante ->
				estudante.concat("-").concat(String.valueOf(estudante.length()))).collect(Collectors.toList()));
		
		//retona somente os três elemento da coleção
		System.out.println("os tres primieros elementos "+estudantes.stream().limit(3).collect(Collectors.toList()));
		
		//exibe cada elemento e depois retorna a mesma coleção
		System.out.println("retorna os elementos "+estudantes.stream().peek(System.out::println).collect(Collectors.toList()));
		
		//exibe cada elemento e retorna outra coleção
		System.out.println("retorna outra coleção");
		estudantes.stream().forEach(System.out::println);
		
		//retorna true se algum elemento possui a letra
		System.out.println("retorna true "+estudantes.stream().allMatch((elemento) -> elemento.contains("T")));
		
		//retorna true se algum elemento possui letra minuscula
		System.out.println("retorna true "+estudantes.stream().anyMatch((elemento) -> elemento.contains("T")));
		
		//retorna true se nenhum elemento possui a letra
		System.out.println("retorna true "+estudantes.stream().noneMatch((elemento) -> elemento.contains("M")));
		
		//operação encadeada
		System.out.println("operação encadeada ");
		System.out.println(estudantes.stream()
				.peek(System.out::println)
				.map(estudante ->
						estudante.concat("-").concat(String.valueOf(estudante.length())))
				.peek(System.out::println)
				.filter((estudante) ->
						 estudante.toLowerCase().contains("r"))
				.collect(Collectors.toList()));
//					.collect(Collectors.joining(", ")));
//					.collect(Collectors.toSet()));
//					.collect(Collectors.groupingBy(estudante -> estudante.substring(estudante.indexOf("-") + 1))));	

	}

}
