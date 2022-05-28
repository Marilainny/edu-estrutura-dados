package edu.mms.estruturadados.collection;
/*
 * O TreeMap em Java é usado para implementar a interface Map, 
 * e NavigableMap junto com a classe AbstractMap. 
 * O mapa é classificado de acordo com a ordem natural de suas chaves,
 * ou por um Comparador fornecido no momento da criação do mapa, 
 * dependendo de qual construtor é usado.
 */
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapMain {

	public static void main(String[] args) {

		TreeMap<String, String>treeCapitais = new TreeMap<>();

		treeCapitais.put("SP", "São Paulo");
		treeCapitais.put("GO", "Goiânia");
		treeCapitais.put("TO", "Palmas");
		treeCapitais.put("RJ", "Rio de Janeiro");
		treeCapitais.put("MG", "Belo Horizonte");
		treeCapitais.put("AL", "Maceió");
		treeCapitais.put("DF", "Brasilia");

		System.out.println(treeCapitais);

		//retorna o primeiro elemento
		System.out.println(treeCapitais.firstKey());

		//retorna o ultimo elemento
		System.out.println(treeCapitais.lastKey());

		//retorno paramentrizado
		System.out.println(treeCapitais.lowerKey("RJ"));

		//retorno paramentrizado
		System.out.println(treeCapitais.higherKey("SP"));

		//retornar a primeiro elemento
		System.out.println(treeCapitais.firstEntry().getKey()+"--"+treeCapitais.firstEntry().getValue());

		//retorno com paramentros		
		System.out.println(treeCapitais.lowerEntry("GO").getKey()+"--"+treeCapitais.lowerEntry("GO").getValue());

		//retornar a ultimo elemento
		System.out.println(treeCapitais.lastEntry().getKey()+"--"+treeCapitais.lastEntry().getValue());

		//retorno com paramentros
		System.out.println(treeCapitais.higherEntry("GO").getKey()+"--"+treeCapitais.higherEntry("GO").getValue());

		//retornar e remover
		Map.Entry<String, String> firstEntry = treeCapitais.pollFirstEntry();
		Map.Entry<String, String> lasttEntry = treeCapitais.pollFirstEntry();
		
		System.out.println(firstEntry.getKey()+"--"+firstEntry.getValue());
		System.out.println(lasttEntry.getKey()+"--"+lasttEntry.getValue());

		System.out.println(treeCapitais);
		
		
		//navegar no mapa
		Iterator<String> iterator = treeCapitais.keySet().iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key +" "+treeCapitais.get(key));
		}
		for(String capital : treeCapitais.keySet()) {
			System.out.println(capital+" "+treeCapitais.get(capital));
		}
		for(Map.Entry<String, String> capital: treeCapitais.entrySet()) {
			System.out.println(capital.getKey()+ " "+capital.getValue());
		}



	}

}
