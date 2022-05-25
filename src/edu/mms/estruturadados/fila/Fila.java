package edu.mms.estruturadados.fila;

import edu.mms.estruturadados.estrutura.EstruturaEstatica;

/**
* A classe Fila comportamento FIFO.
*    
* @author  	 Marilainny Martins da Silva
* @version 	 1.0
* @since     12.05.2022
* @implNote  Estudo estrutura de dados.  			 
*/

public class Fila<T> extends EstruturaEstatica<T>{
	
	public Fila() {
		super(); 
		//chamar o construtor da classe EstruturaEstatica.
	}
	
	public Fila(int capacidade) {
		super(capacidade); 
		//chamar o construtor da classe EstruturaEstatica com capacidade.
	}
	
	public void enfileirar(T elemento) {
		this.adicionarElemento(elemento); 
		//vai verificar a capacidade, incluir o elementos no array de elementos e atualizar a variavél tamanho;
	}
	
	public T espiarFila() {
		
		if(this.estarVazia()) {
			return null;
		}
		
		return this.elementos[0];
		//retorna o elemento que foi inserido primeiro;
	}
	
	public T removerElementoFila() {
		
		final int POSICAO = 0;
		
		if(this.estarVazia()) {
			return null;
		}
		
		T elementoRemover = this.elementos[POSICAO];
		super.removerElemento(POSICAO);
		return elementoRemover;
	}


}
