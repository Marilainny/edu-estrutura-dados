package edu.mms.estruturadados.teste;

import java.util.Scanner;

import edu.mms.estruturadados.lista.ListaModelo;
import edu.mms.estruturadados.model.Contato;

public class TesteListaContatos {

	public static void main(String[] args) {

		//criação das váriaveis.
		Scanner scan = new Scanner(System.in);

		//criar vetor com 20 de capacidade.
		ListaModelo<Contato>lista = new ListaModelo<Contato>(20);

		//criar e adicionar 30 contatos.
		criarContatoDinamicamente(10, lista);

		//criar um menu de opção.
		int opcao = 1;

		while(opcao != 00){
			opcao = obterOpcaoMenu(scan);

			switch (opcao) {
			case 1: 
				adicionarContatoFinal(scan, lista);
				break;
			case 2: 
				adicionarContatoPosicao(scan, lista);
				break;
			case 3: 
				obtemContatoPosicao(scan, lista);				
				break;
			case 4: 
				obtemContato(scan, lista);
				break;
			case 5: 
				pesquisarUltimoIndece(scan, lista);
				break;
			case 6: 
				pesquisaContatoExiste(scan, lista);
				break;
			case 7: 
				excluirPorPosicao(scan, lista);
				break;
			case 8: 
				excluirContato(scan, lista);
				break;
			case 9: 
				imprimeTamanhoVetor(lista);
				break;
			case 10: 
				limpaVetor(lista);
				break;
			case 11: 
				imprimirVetor(lista);
				break;
			default:
				break;
			}
		}
		System.out.println("Usuário digitou zero e programa saiu");		
	}

	/*
	 * Método para obter opção do menu, retornando um número inteiro.
	 * 	parametro Scanner para pegar a informação do usúario.
	 *  validar se a entrada é válida, enquanto não for válida mostrar o menu.
	 *  obter e validar a entrada do usuarios da opção do menu selecionada.
	 *  se entrada é valida retorna a opção.
	 */
	public static int obterOpcaoMenu(Scanner scan) {

		boolean entradaValida = false;
		String entrada;
		int opcao = 0;

		while(!entradaValida) {

			System.out.println("Digite uma opção");
			System.out.println("01: Adiciona contato no final do vetor");
			System.out.println("02: Adiciona contato em uma posição específica");
			System.out.println("03: Obtém contato em uma posição específica");
			System.out.println("04: Consulta contato");
			System.out.println("05: Consulta último índice do contato");
			System.out.println("06: Verificar se contato existe");
			System.out.println("07: Excluir por posição");
			System.out.println("08: Excluir contato");
			System.out.println("09: Verifica tamanho do vetor");
			System.out.println("10: Excluir todos os contatos");
			System.out.println("11: Imprime vetor");
			System.out.println("00: Sair\n\n");

			try {
				entrada = scan.nextLine();
				opcao = Integer.parseInt(entrada);

				if(opcao >= 0 && opcao <= 11) {
					entradaValida = true;					
				}else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("\nEntrada inválida, digite novamente.\n\n");
			}	
		}			
		return opcao;
	}

	public static void limpaVetor(ListaModelo<Contato>lista) {
		lista.limpar();

		System.out.println("Todos os contatos do vetor foram excluidos.");
	}

	public static void imprimirVetor(ListaModelo<Contato>lista) {
		System.out.println(lista);
	}

	public static void imprimeTamanhoVetor(ListaModelo<Contato>lista) {
		System.out.println("Tamanho do vetor é "+lista.tamanho());
	}

	public static void excluirPorPosicao(Scanner scan, ListaModelo<Contato>lista) {
		int pos = lerInformacaoInt("Entre com a posição a ser removida", scan);

		try {
			lista.remove(pos);		
			System.out.println("Contato Excluido");
		} catch (Exception e) {
			System.out.println("Contato não existe");
		}
	}

	public static void excluirContato(Scanner scan, ListaModelo<Contato>lista) { int
		pos = lerInformacaoInt("Entre com a posição a ser removida", scan);

	try {Contato contato = lista.busca(pos); lista.remove(contato);
	System.out.println("Contato Excluido"); } catch (Exception e) {
		System.out.println("Contato não existe"); } }

	public static void pesquisaContatoExiste(Scanner scan, ListaModelo<Contato>lista) {
		int pos = lerInformacaoInt("Entre com a posição a ser pesquisada", scan);

		try {Contato contato = lista.busca(pos); boolean existe =
				lista.contem(contato);

		if(existe) { System.out.println("Contato existe, segue os dados");
		System.out.println(contato); }else {
			System.out.println("Contato não existe."); } } catch (Exception e) {
				System.out.println("Posição inválida, contato não adicionado"); } } 

	public static void obtemContatoPosicao(Scanner scan, ListaModelo<Contato>lista) { int pos
		= lerInformacaoInt("Entre com a posição a ser pesquisada", scan);

	try {Contato contato = lista.busca(pos);
	System.out.println("Contato existe, segue os dados");
	System.out.println(contato); } catch (Exception e) {
		System.out.println("Posição inválida, contato não adicionado"); } }

	public static void pesquisarUltimoIndece(Scanner scan, ListaModelo<Contato>lista) {

		int pos = lerInformacaoInt("Entre com a posição a ser pesquisada", scan);

		try { Contato contato = lista.busca(pos);
		System.out.println("Contato existe, segue os dados");
		System.out.println(contato);
		System.out.println("Fazendo pesquisa do último indice contato"); pos =
				lista.ultimoIndice(contato); System.out.println("Contato encontrado é"+pos);
		} catch (Exception e) {
			System.out.println("Posição inválida, contato não adicionado"); } }

	public static void obtemContato(Scanner scan, ListaModelo<Contato>lista) { 
		int pos = lerInformacaoInt("Entre com a posição a ser pesquisada", scan);

		try { Contato contato = lista.busca(pos);
		System.out.println("Contato existe, segue os dados");
		System.out.println(contato);
		System.out.println("Fazendo pesquisa do contato encontrado"); pos =
				lista.busca(contato);
		System.out.println("Contato encontrado na posição"+pos); } catch (Exception
				e) { System.out.println("Posição inválida, contato não adicionado"); } }

	public static void adicionarContatoFinal(Scanner scan, ListaModelo<Contato>lista) {
		System.out.println("Criando um contato, entre com as informações");
		String nome = lerInformacao("Entre com o nome", scan);
		String telefone = lerInformacao("Entre com o telefone", scan);
		String email = lerInformacao("Entre com o e-mail", scan);

		Contato contato = new Contato(nome, telefone, email);

		lista.adiciona(contato);

		System.out.println("Contato adicionado com sucesso");
		System.out.println(contato);

	}

	public static void adicionarContatoPosicao(Scanner scan, ListaModelo<Contato>lista) {
		System.out.println("Criando um contato, entre com as informações");
		String nome = lerInformacao("Entre com o nome", scan);
		String telefone = lerInformacao("Entre com o telefone", scan);
		String email = lerInformacao("Entre com o e-mail", scan);

		Contato contato = new Contato(nome, telefone, email);

		int pos = lerInformacaoInt("Entre com a posição a adicionar o contato.", scan);

		try {
			lista.adiciona(pos, contato);
			System.out.println("Contato adicionado com sucesso");
			System.out.println(contato);
		} catch (Exception e) {
			System.out.println("Posição inválida, contato não adicionado");
		}
	}
	/*
	 * Ler as informações para criar um contato
	 */
	public static String lerInformacao(String msg, Scanner scan) {
		System.out.println(msg);
		String entrada = scan.nextLine();

		return entrada;
	}

	public static int lerInformacaoInt(String msg, Scanner scan) {
		boolean entradaValida = false;
		int num = 0;

		while(!entradaValida) {
			try {
				System.out.println(msg);
				String entrada = scan.nextLine();

				num = Integer.parseInt(entrada);

				entradaValida = true;

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return num;
	}
	/*
	 * Método para criar contato automatico - Static para ser usado pela main.
	 * 	precisa passar o vetor como parametro onde será adicionado os contatos.
	 * 
	 */
	public static void criarContatoDinamicamente(int quantidade, ListaModelo<Contato>lista) {
		Contato contato; 
		for(int i=1; i<= quantidade; i++) {
			contato = new Contato();
			contato.setName("AAAA"+i);
			contato.setEmail("contato"+i+"@gmail.com");
			contato.setTelefone("(62)3933-4345"+i);

			lista.adiciona(contato);
		}		
	}


}

