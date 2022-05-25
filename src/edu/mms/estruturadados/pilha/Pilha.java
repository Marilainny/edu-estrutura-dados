package edu.mms.estruturadados.pilha;

import edu.mms.estruturadados.estrutura.EstruturaEstatica;

/**Classe para aumentar a capacidade da pilha e empilhar elementos.
* @author Marilainny Martins da Siva
* @version 1.00
* @since 21.04.22 release - 21.04.22 
*/
public class Pilha<T> extends EstruturaEstatica<T> {
	
	public Pilha(){
		super();
	}
	
	/* 
	 * Método a partir da super classe para aumentar a capacidade do Vetor
	 */
	public Pilha(int capacidade) {
		super(capacidade);
	}
	
	/* 
	 * Método para empilhar os elementos, que adiciona a partir da super classe
	 */
	public void empilhar(T elemento) {
		super.adicionarElemento(elemento);
	}

}
