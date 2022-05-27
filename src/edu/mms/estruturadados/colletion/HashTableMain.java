package edu.mms.estruturadados.colletion;

import java.util.Hashtable;
import java.util.Map;

public class HashTableMain {

	public static void main(String[] args) {

		Hashtable<String, Integer> estudantes = new Hashtable<>();

		estudantes.put("Carlos", 21);
		estudantes.put("Adriano", 33);
		estudantes.put("Luciana", 45);
		estudantes.put("Paula", 18);
		estudantes.put("Romeo", 15);
		
		System.out.println(estudantes);
		
		//adicionar
		estudantes.put("Jesus", 33);
		
		System.out.println(estudantes);
		
		//remover
		estudantes.remove("Jesus");
		
		System.out.println(estudantes);
		
		//recuperar
		int idadeEstudante = estudantes.get("Luciana");
		
		System.out.println(idadeEstudante);
		
		System.out.println("Tamanho: "+estudantes.size());
		
		//navegar nos elementos
		for(Map.Entry<String, Integer> entry : estudantes.entrySet()) {
			System.out.println(entry.getKey()+ "  "+entry.getValue());
		}
		
		for(String key : estudantes.keySet()) {
			System.out.println(key + "   "+estudantes.get(key));
		}
		
		System.out.println(estudantes);

	}

}
