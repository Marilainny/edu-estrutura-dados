package edu.mms.estruturadados.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Permite valores repetidos mas não permite repetição de chave;
 * Permite adição e busca por chave ou valor.
 * Atualização, remoção e navegação;
 * Pode ser ordenado.
 */
public class MapMain {

	public static void main(String[] args) {

		Map<String, Integer> campeoesMundialFifa = new HashMap<>();
		
		//segundo campo pode ser uma lista
		Map<String, List<Integer>> exemplo = new HashMap<>();

		//Lista
		campeoesMundialFifa.put("Brasil", 5);
		campeoesMundialFifa.put("Alemanha", 4);
		campeoesMundialFifa.put("Itália", 4);
		campeoesMundialFifa.put("Uruguai", 2);
		campeoesMundialFifa.put("Argentina", 2);
		campeoesMundialFifa.put("França", 2);
		campeoesMundialFifa.put("Espanha", 1);

		System.out.println(campeoesMundialFifa);

		//Atualiza a chave
		campeoesMundialFifa.put("Brasil", 6);

		System.out.println(campeoesMundialFifa);

		//Retornar um elemento
		System.out.println(campeoesMundialFifa.get("Argentina"));

		//Verificar se o elemento 
		System.out.println(campeoesMundialFifa.containsKey("França"));

		//Remover elemento
		campeoesMundialFifa.remove("França");

		//Verificar se o elemento 
		System.out.println(campeoesMundialFifa.containsKey("França"));
		
		System.out.println(campeoesMundialFifa);
		
		//retornar o tamanho do mapa
		System.out.println(campeoesMundialFifa.size());
		
		//Navegar pelo mapa
		for(Map.Entry<String , Integer> entry : campeoesMundialFifa.entrySet()) {
			System.out.println(entry.getKey()+"--"+entry.getValue());
		}
		
		//verificar se o mapa contem o valor
		System.out.println(campeoesMundialFifa.containsValue(5));

	}

}
