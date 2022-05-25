package edu.mms.estruturadados.vetor;

public class VetorObjeto {

	/*
	 *Declaração das variáveis. 
	 */
	private Object[] elementos; //vetor de Strings
	private int tamanho; //variavel para amarzenar o tamanho real do vetor.

	/*
	 * método retorna o tamanho atual do vetor.
	 */
	public int tamanho(){
		return this.tamanho;		
	}

	/*
	 * Método para delimitar a capacidadde do array.
	 * 	primeiro: sempre que criar um vetor será solicitado a capacidade deste vetor.
	 *  segundo: inicia o tamanho a partir de 0;
	 */
	public VetorObjeto(int capacidade){
		this.elementos = new Object[capacidade];
		this.tamanho = 0;
	}

	/*
	 * Método para aumentar a capacidade do vetor após ter inserido o limite do seu tamanho.
	 * 	primeiro: verificar se o tamanho atual é igual ao tamanho do total de elementos do vetor.
	 *  segundo: declarar outro vetor do mesmo tipo que vai receber o vetor tamanho duas vezes o tamanho.
	 *  terceiro: atribuir pelo for as posições do vetor iniciando na posição zero até o tamanho da posição final, interando mais 1.
	 *  quarto: atribuir o vetor novo ao vetor já existente.
	 */

	private void aumentaCapacidade() {
		if(this.tamanho == this.elementos.length) { 
			Object[] newElementos = new Object[this.elementos.length * 2];
			for(int i=0; i<this.elementos.length; i++) {
				newElementos[i] = this.elementos[i]; 
			}
			this.elementos = newElementos;
		}
	}

	/*
	 * Método para adicionar um valor ao array.
	 * 	primeiro:verificar se o tamanho é menor que o tamanho do array elementso antes de inserir. 
	 *  segundo: vetor elementos inicia com o tamanho e adiciona elemento.
	 *  terceiro: elemento recebe tamanho(posição) o elemento;
	 *  quarto: ao finalizar adiciona um valor ao tamanho.  
	 */
	public boolean adiciona(Object elemento){
		this.aumentaCapacidade(); //chamando outro método.
		if (this.tamanho < this.elementos.length) {		
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;			
			return true;
		}

		return false;

	}

	/*
	 * Método para adicionar um valor em uma posição.
	 * 	primeiro: verificar se a posição é válida.
	 *  segudno: se a posição é maior ou igual a zero e menor que o tamanho.
	 *  terceiro: usa a negação para todos os elementos que não enquadrar na condição é lança uma exeption.
	 *  quarto: no for "i" vai começar do tamanho menos uma posição, a variavel i tem que ser maior ou igual a posição que está passando.
	 *  quinto: na posição maior que o tamanho, (vazio) recebe a posição atual.
	 *  
	 *Exemplo:
	 *	0 1 2 3 4 5 6 7 --> TAMANHO = 5
	 *	B C E F G + + +
	 *	i = 5 - 1 = 4
	 *	i+1 = 4+1
	 */
	public boolean adiciona(int posicao, Object elemento) {
		this.aumentaCapacidade(); // chamando outro método.
		if (!(posicao >=0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição Inválida");			
		}
		for (int i = this.tamanho-1; i >= elementos.length; i--) {
			this.elementos[i+1] = this.elementos[i];
		}		
		return false;
	}
	/*
	 * Método para remover um elemento de qualquer posição.
	 * 	primeiro: passar a posição que quer remover.
	 *  segundo: verificar se a posição é válida.
	 *  terceiro: for recebe a posição a ser removida.
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
			throw new IllegalArgumentException("Posição Inválida");			
		}
		for(int i=posicao; i < this.tamanho -1; i++) {
			this.elementos[i] = elementos[i + 1];
		} this.tamanho --;
	}

	public void removeElemento(String elemento) {
		int resultado = this.busca(elemento);
		if(resultado > -1) {
			this.remove(resultado);
		}else {
			throw new IllegalArgumentException("Elemento não existe");
		}
	}

	/*
	 * Método de busca das posição do vetor.
	 * 	primeiro: usuário informa a posição.	
	 *  segundo: se a posição é maior ou igual a zero e menor que o tamanho.
	 *  terceiro: usa a negação para todos os elementos que não enquadrar na condição é lança uma exeption.
	 *  quarto: caso estiver de acordo com a condição retorna a posição. 
	 */
	public Object busca(int posicao) {
		if (!(posicao >=0 && posicao < tamanho)) {			
			throw new IllegalArgumentException("Posição Inválida");			
		}	
		return elementos[posicao];		
	}

	/*
	 * Método de busca SEQUÊNCIAL das posição do vetor.
	 * 	primeiro: usuário informa o texto.
	 *  
	 */
	public int busca(Object elemento) {	//	
		for(int i=0; i< tamanho; i++) { //for para ler os dados
			if(elementos[i].equals(elemento)) { //Se elemento digitado for (equals) devido ser String, então retorna a posição.
				return i;
			}
		}
		return -1; // se não retorna uma posição não existente, -1 não existe no vetor.
	}

	//método para imprimir todos os elementos do vetor
	@Override
	public String toString() {

		StringBuilder vetorElementos = new StringBuilder(); //construtor builder para impressão dos dados formatado.

		vetorElementos.append("[");

		for (int i = 0; i < this.tamanho-1; i++) { //tamanho vai até a penultima interação.
			vetorElementos.append(this.elementos[i]);
			vetorElementos.append(", ");

		}

		if (this.tamanho>0){//verificar se tem dados para imprimir
			vetorElementos.append(this.elementos[this.tamanho-1]); //acessando a última posição.

		}

		vetorElementos.append("]");
		return vetorElementos.toString();
	}

}
