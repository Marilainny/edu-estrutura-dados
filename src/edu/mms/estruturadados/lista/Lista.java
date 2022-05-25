package edu.mms.estruturadados.lista;

import java.lang.reflect.Array;

public class Lista<T> {
	
	/*
	 *Declara��o das vari�veis. 
	 */
	private T[] elementos; //vetor de Strings
	private int tamanho; //variavel para amarzenar o tamanho real do vetor.

	/*
	 * m�todo retorna o tamanho atual do vetor.
	 */
	public int tamanho(){
		return this.tamanho;		
	}

	public Lista() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * M�todo para delimitar a capacidadde do array.
	 * 	primeiro: sempre que criar um vetor ser� solicitado a capacidade deste vetor.
	 *  segundo: inicia o tamanho a partir de 0;
	 *Para fazer um construtor de genericos
	 */
	public Lista(int capacidade){
		this.elementos = (T[]) new Object[capacidade];
		this.tamanho = 0;
	}

	/*
	 * Outra forma de fazer um construtor.
	 */
	public Lista(int capacidade, Class<T> tipoClasse){
		this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
		this.tamanho = 0;
	}

	/*
	 * M�todo para aumentar a capacidade do vetor ap�s ter inserido o limite do seu tamanho.
	 * 	primeiro: verificar se o tamanho atual � igual ao tamanho do total de elementos do vetor.
	 *  segundo: declarar outro vetor do mesmo tipo que vai receber o vetor tamanho duas vezes o tamanho.
	 *  terceiro: atribuir pelo for as posi��es do vetor iniciando na posi��o zero at� o tamanho da posi��o final, interando mais 1.
	 *  quarto: atribuir o vetor novo ao vetor j� existente.
	 */

	private void aumentaCapacidade() {
		if(this.tamanho == this.elementos.length) { 
			T[] newElementos = (T[]) new Object[this.elementos.length * 2];
			for(int i=0; i<this.elementos.length; i++) {
				newElementos[i] = this.elementos[i]; 
			}
			this.elementos = newElementos;
		}
	}

	/*
	 * M�todo para adicionar um valor ao array.
	 * 	primeiro:verificar se o tamanho � menor que o tamanho do array elementso antes de inserir. 
	 *  segundo: vetor elementos inicia com o tamanho e adiciona elemento.
	 *  terceiro: elemento recebe tamanho(posi��o) o elemento;
	 *  quarto: ao finalizar adiciona um valor ao tamanho.  
	 */
	public boolean adiciona(T elemento){
		this.aumentaCapacidade(); //chamando outro m�todo.
		if (this.tamanho < this.elementos.length) {		
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;			
			return true;
		}

		return false;

	}

	/*
	 * M�todo para adicionar um valor em uma posi��o.
	 * 	primeiro: verificar se a posi��o � v�lida.
	 *  segudno: se a posi��o � maior ou igual a zero e menor que o tamanho.
	 *  terceiro: usa a nega��o para todos os elementos que n�o enquadrar na condi��o � lan�a uma exeption.
	 *  quarto: no for "i" vai come�ar do tamanho menos uma posi��o, a variavel i tem que ser maior ou igual a posi��o que est� passando.
	 *  quinto: na posi��o maior que o tamanho, (vazio) recebe a posi��o atual.
	 *  
	 *Exemplo:
	 *	0 1 2 3 4 5 6 7 --> TAMANHO = 5
	 *	B C E F G + + +
	 *	i = 5 - 1 = 4
	 *	i+1 = 4+1
	 */
	public boolean adiciona(int posicao, T elemento) {
		this.aumentaCapacidade(); // chamando outro m�todo.
		if (!(posicao >=0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posi��o Inv�lida");			
		}
		for (int i = this.tamanho-1; i >= elementos.length; i--) {
			this.elementos[i+1] = this.elementos[i];
		}		
		return false;
	}
	/*
	 * M�todo para remover um elemento de qualquer posi��o.
	 * 	primeiro: passar a posi��o que quer remover.
	 *  segundo: verificar se a posi��o � v�lida.
	 *  terceiro: for recebe a posi��o a ser removida.
	 *
	 *  EXEMPLO:
	 *  B G E D F --> Remover G
	 *  0 1 2 3 4 --> Tamanho 5
	 *  vetor[1] = vetor[2]
	 *  vetor[2] = vetor[3]
	 *  vetor[3] = vetor[4]
	 *  
	 *  B E D F F --> Removeu G e voltou uma casa para o tamanho.
	 *  0 1 2 3 F --> F torna lixo.
	 */

	public void remove(int posicao) {
		if (!(posicao >=0 && posicao < tamanho)) {			
			throw new IllegalArgumentException("Posi��o Inv�lida");			
		}
		for(int i=posicao; i < this.tamanho -1; i++) {
			this.elementos[i] = elementos[i + 1];
		} this.tamanho --;
	}

	public void remove(T posicao) {
		int pos = this.busca(posicao);
		if(pos > -1) {
			this.remove(pos);
		}
	}
	/*
	 * M�todo para limpar todos os elementos de um Array
	 * op��o 1 que cria um novo array recebendo o anterior mantem a memoria anterior.
	 * op��o 2 que inicia o array na posi��o zero, assim os valores anteriores seriam substituido mantendo a memoria.
	 * op��o 3 que atribui null a todos os elementos do array e depois inicia o tamanho na posi��o zero liberando a memoria. 
	 * 
	 */

	public void limpar() {
		//op��o 1
		//this.elementos = (T[]) new Object[this.elementos.length];

		//op��o 2
		//this.tamanho = 0;

		//op�ao 3
		for (int i=0; i < this.tamanho; i++) {
			this.elementos[i] = null;
		}
		this.tamanho = 0;		
	}
	/*
	 * M�todo de busca das posi��o do vetor.
	 * 	primeiro: usu�rio informa a posi��o.	
	 *  segundo: se a posi��o � maior ou igual a zero e menor que o tamanho.
	 *  terceiro: usa a nega��o para todos os elementos que n�o enquadrar na condi��o � lan�a uma exeption.
	 *  quarto: caso estiver de acordo com a condi��o retorna a posi��o. 
	 */
	protected T busca(int posicao) {
		if (!(posicao >=0 && posicao < tamanho)) {			
			throw new IllegalArgumentException("Posi��o Inv�lida");			
		}	
		return elementos[posicao];		
	}


	/*
	 * M�todo de buscar elemento 
	 */

	public boolean contem(T elemento) {
		return busca(elemento) > -1; 

	}

	/*
	 * M�todo de busca SEQU�NCIAL das posi��o do vetor.
	 * 	primeiro: usu�rio informa o texto.
	 *  for para ler os dados.
	 *  se elemento digitado for (equals) devido ser String, ent�o retorna a posi��o.
	 *  se n�o retorna uma posi��o n�o existente, -1 n�o existe no vetor.
	 */
	protected int busca(T elemento) {		
		for(int i=0; i< tamanho; i++) { 
			if(elementos[i].equals(elemento)) { 
				return i;
			}
		}
		return -1; 
	}

	/*
	 * Buscar a posi��o usando o T.
	 */

	public T obtem(int posicao) {
		return this.busca(posicao);
	}

	/*
	 * M�todo de busca por indice.
	 * 	primeiro o usu�rio informa o texto.
	 *  a v�riavel ultimaPos salva o indice do elemento ao encontrar.
	 *  o i vai da posi��o final tamanho -1 at� zero, decrementando.
	 *  neste processo os valores ser�o comparado, do ultimo para o primeiro, assim ele vai pegar a ultima posi��o que aquele elemento � encontrado. 
	 * 	
	 */

	public int ultimoIndice(T elemento) {
		int ultimaPos;
		for(int i=this.tamanho-1; i>=0; i--) { 
			if(elementos[i].equals(elemento)) { 
				return i;
			}
		} 
		return -1;		
	}


	//m�todo para imprimir todos os elementos do vetor
	@Override
	public String toString() {

		StringBuilder vetorElementos = new StringBuilder(); //construtor builder para impress�o dos dados formatado.

		vetorElementos.append("[");

		for (int i = 0; i < this.tamanho-1; i++) { //tamanho vai at� a penultima intera��o.
			vetorElementos.append(this.elementos[i]);
			vetorElementos.append(", ");

		}

		if (this.tamanho>0){//verificar se tem dados para imprimir
			vetorElementos.append(this.elementos[this.tamanho-1]); //acessando a �ltima posi��o.

		}

		vetorElementos.append("]");
		return vetorElementos.toString();
	}


}
