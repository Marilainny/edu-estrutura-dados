package edu.mms.estruturadados.fila;
/**
* A classe FilaPrioridade.
*    Uma fila de prioridade valor é adicionado na Fila padrão.
*    
* @author  	 Marilainny Martins da Silva
* @version 	 1.0
* @since     12.05.2022
* @implNote  Estudo estrutura de dados.  			 
*/
public class FilaPrioridade<T> extends Fila<T>{
	
	public void enfileirar(T elemento) {
		
		@SuppressWarnings("unchecked")
		Comparable<T> chave = (Comparable<T>) elemento;
		
		int i;
		
		for( i = 0; i < this.tamanho; i++) {			
			if(chave.compareTo(this.elementos[i]) < 0) {
				break;				
			}
		}
		this.adicionarPosicaoElemento(i, elemento);
	} 
}
