package edu.mms.estruturadados.vetor;

public class VetorObjeto {

	/*
	 *Declara��o das vari�veis. 
	 */
	private Object[] elementos; //vetor de Strings
	private int tamanho; //variavel para amarzenar o tamanho real do vetor.

	/*
	 * m�todo retorna o tamanho atual do vetor.
	 */
	public int tamanho(){
		return this.tamanho;		
	}

	/*
	 * M�todo para delimitar a capacidadde do array.
	 * 	primeiro: sempre que criar um vetor ser� solicitado a capacidade deste vetor.
	 *  segundo: inicia o tamanho a partir de 0;
	 */
	public VetorObjeto(int capacidade){
		this.elementos = new Object[capacidade];
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
			Object[] newElementos = new Object[this.elementos.length * 2];
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
	public boolean adiciona(Object elemento){
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
	public boolean adiciona(int posicao, Object elemento) {
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

	public void removeElemento(String elemento) {
		int resultado = this.busca(elemento);
		if(resultado > -1) {
			this.remove(resultado);
		}else {
			throw new IllegalArgumentException("Elemento n�o existe");
		}
	}

	/*
	 * M�todo de busca das posi��o do vetor.
	 * 	primeiro: usu�rio informa a posi��o.	
	 *  segundo: se a posi��o � maior ou igual a zero e menor que o tamanho.
	 *  terceiro: usa a nega��o para todos os elementos que n�o enquadrar na condi��o � lan�a uma exeption.
	 *  quarto: caso estiver de acordo com a condi��o retorna a posi��o. 
	 */
	public Object busca(int posicao) {
		if (!(posicao >=0 && posicao < tamanho)) {			
			throw new IllegalArgumentException("Posi��o Inv�lida");			
		}	
		return elementos[posicao];		
	}

	/*
	 * M�todo de busca SEQU�NCIAL das posi��o do vetor.
	 * 	primeiro: usu�rio informa o texto.
	 *  
	 */
	public int busca(Object elemento) {	//	
		for(int i=0; i< tamanho; i++) { //for para ler os dados
			if(elementos[i].equals(elemento)) { //Se elemento digitado for (equals) devido ser String, ent�o retorna a posi��o.
				return i;
			}
		}
		return -1; // se n�o retorna uma posi��o n�o existente, -1 n�o existe no vetor.
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
