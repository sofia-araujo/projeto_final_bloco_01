package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_01.controller.Controller;
import projeto_final_bloco_01.model.FrutoSeco;
import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.model.Tempero;
import projeto_final_bloco_01.util.Cores;

public class Menu {
	private static final Scanner leia = new Scanner(System.in);
	private static final Controller produtoController = new Controller();
	
	public static void main(String[] args) {
		int opcao;
//		criarProdutosTeste();
		
		while (true) {
			
			System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("              Nutivida Produtos Naturais             ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Produto                        ");
			System.out.println("            2 - Listar todos os Produtos             ");
			System.out.println("            3 - Buscar Produto por id                ");
			System.out.println("            4 - Atualizar Produto                    ");
			System.out.println("            5 - Deletar Produto                      ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			}catch(InputMismatchException e){
				opcao = -1;
				System.out.println("\nDigite um número inteiro entre 0 e 5");
				leia.nextLine();
			}

			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nE-commerce Nutrivida sua saúde mais perto de você!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Produto\n\n");
				cadastrarProduto();
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todos os Produtos\n\n");
				listarProdutos();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Buscar Produto por Id\n\n");
				procurarProdutoPorId();
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar Produto\n\n");
				atualizarProduto();
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Deletar Produto\n\n");
				deletarProduto();
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}

	}
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Sofia de Aráujo - sofiiagomes34@gmail.com");
		System.out.println("github.com/sofia-araujo");
		System.out.println("*********************************************************");
	}
	
	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
		leia.nextLine();
	}
	
//	private static void criarProdutosTeste() {
//		produtoController.cadastrar(new FrutoSeco(produtoController.gerarId(), "Nozes Premium", 30.99f, 1, 2));
//		produtoController.cadastrar(new FrutoSeco(produtoController.gerarId(), "Mix de Castanhas", 50.99f, 1, 1));	
//	}
	
	private static void listarProdutos() {
		produtoController.listarTodas();
	}
	
	private static void cadastrarProduto() {

		System.out.print("Digite o nome do produto: ");
		String nome = leia.nextLine();

		System.out.print("Digite o Categoria do produto (1 - FrutoSeco | 2 - Tempero): ");
		int categoria = leia.nextInt();

		System.out.print("Digite o Preço do produto: ");
		float preco = leia.nextFloat();

		switch (categoria) {
		case 1 -> {
			System.out.print("Digite o tipo de fruto (1 - Castanha | 2 - Noz | 3 - Amêndoa): ");
			int tipoFruto = leia.nextInt();
			leia.nextLine();
			
			produtoController.cadastrar(new FrutoSeco(produtoController.gerarId(), nome, preco,  categoria, tipoFruto));
		}
		case 2 -> {
			System.out.print("Digite o Sabor: ");
			leia.skip("\\R");
			String sabor = leia.nextLine();
			
			System.out.print("Digite a Origem (País): ");
			String origem = leia.nextLine();
			
			produtoController.cadastrar(new Tempero(produtoController.gerarId(), nome, preco,  categoria, sabor, origem));
		}
			default -> System.out.println(Cores.TEXT_RED + "Categoria de produto inválido!" + Cores.TEXT_RESET);
		}
	}
	
	private static void procurarProdutoPorId() {

		System.out.print("Digite o Id do produto: ");
		int id = leia.nextInt();
		leia.nextLine();

		produtoController.procurarPorId(id);
	}
	
	private static void deletarProduto() {

		System.out.print("Digite o Id do produto: ");
		int id = leia.nextInt();
		leia.nextLine();

		Produto produto = produtoController.buscarNaCollection(id);

		if (produto != null) {

			System.out.print("\nTem certeza que deseja excluir o produto? (S/N): ");
			String confirmacao = leia.nextLine();

			if (confirmacao.equalsIgnoreCase("S")) {
				produtoController.deletar(id);
			} else {
				System.out.println("\nOperação cancelada!");
			}

		} else {
			System.out.printf("\nO produto Id %d não foi encontrado!", id);
		}
	}
	
	private static void atualizarProduto() {

		System.out.print("Digite o Id do produto: ");
		int id = leia.nextInt();
		leia.nextLine();

		Produto produto = produtoController.buscarNaCollection(id);

		if (produto != null) {

			String nome = produto.getNome();
			int categoria = produto.getCategoria();
			float preco = produto.getPreco();

			System.out.printf(
					"Nome atual: %s\nDigite o novo nome do Produto (Pressione ENTER para manter o valor atual): ", nome);
			String entrada = leia.nextLine();
			nome = entrada.isEmpty() ? nome : entrada;

			System.out.printf("Preço atual: %.2f\nDigite o novo Preço (Pressione ENTER para manter o valor atual): ",
					preco);
			entrada = leia.nextLine();
			preco = entrada.isEmpty() ? preco : Float.parseFloat(entrada.replace(",", "."));

			switch (categoria) {
			case 1 -> {
				int tipoFruto = ((FrutoSeco) produto).getTipoFruto();
				
				System.out.printf(
						"Tipo do fruto atual é: %d\nDigite o novo tipo de fruto (1 - Castanha | 2 - Noz | 3 - Amêndoa) (Pressione ENTER para manter o valor atual): ",
						tipoFruto);
				entrada = leia.nextLine();
				tipoFruto = entrada.isEmpty() ? tipoFruto : Integer.parseInt(entrada.replace(",", "."));
				produtoController.atualizar(new FrutoSeco(id, nome, preco, categoria, tipoFruto));
			}
			case 2 -> {
				String sabor = ((Tempero) produto).getSabor();
				String origem = ((Tempero) produto).getOrigem();
				
				System.out.printf(
						"O Sabor atual é: %s\nDigite o novo sabor (Pressione ENTER para manter o valor atual): ",
						sabor);
				entrada = leia.nextLine();
				sabor = entrada.isEmpty() ? sabor : entrada;
				
				System.out.printf(
						"A Origem atual é: %s\nDigite a nova Origem (Pressione ENTER para manter o valor atual): ",
						origem);
				entrada = leia.nextLine();
				origem = entrada.isEmpty() ? origem : entrada;
				produtoController.atualizar(new Tempero(id, nome, preco, categoria, sabor, origem));
			}
			default -> System.out.println(Cores.TEXT_RED + "Categoria de produto inválido!" + Cores.TEXT_RESET);
			}

		} else {
			System.out.printf("\nO produto número %d não foi encontrado!", id);
		}
	}
}
