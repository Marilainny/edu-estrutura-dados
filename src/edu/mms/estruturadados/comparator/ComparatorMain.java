package edu.mms.estruturadados.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain {

	public static void main(String[] args) {
		
		List<Estudante> estudantes = new ArrayList<>();
		
		estudantes.add(new Estudante("CARLOS", 19));
		estudantes.add(new Estudante("LUANA", 49));
		estudantes.add(new Estudante("THIAGO", 36));
		estudantes.add(new Estudante("LUIZ", 19));
		estudantes.add(new Estudante("LAURA", 17));
		estudantes.add(new Estudante("TATIANA", 19));
		
		System.out.println("Ordem de Inserção");
		System.out.println(estudantes);
		
		System.out.println("Expressão Lambda ordem natural");
		estudantes.sort((first, secound) -> first.getIdade() - secound.getIdade() );
		System.out.println(estudantes);	
		
		System.out.println("Expressão Lambda Ordem reversa");
		estudantes.sort((first, secound) -> secound.getIdade() - first.getIdade());
		
		//precisa implementar na classe a interface Comparator
		System.out.println("Ordem natural");
		estudantes.sort(Comparator.comparingInt(Estudante::getIdade));
		System.out.println(estudantes);
		
		System.out.println("Ordem reversa");
		estudantes.sort(Comparator.comparingInt(Estudante::getIdade).reversed());
		System.out.println(estudantes);
		
		Collections.sort(estudantes);
		
		System.out.println("Ordem natural");
		System.out.println(estudantes);
		
		Collections.sort(estudantes, new EstudanteOrdemInversaComparator());
		
		System.out.println("Ordem reversa");
		System.out.println(estudantes);
		
		
		
	}

}
