package edu.mms.estruturadados.lista;

import edu.mms.estruturadados.estrutura.EstruturaEstatica;

public class ListaAumentaCapacidade<T> extends EstruturaEstatica<T> {
	
	public ListaAumentaCapacidade(){
		super();
	}
	
	public ListaAumentaCapacidade(int capacidade) {
		super(capacidade);
	}
	
	public boolean adicionarElemento(T elemento) {
		return super.adicionarElemento(elemento);
	}

	public boolean adicionarPosicaoElemento (int posicao, T elemento) {
		return super.adicionarPosicaoElemento(posicao, elemento);
	}

}
