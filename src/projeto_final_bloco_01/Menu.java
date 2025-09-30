package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_01.util.Cores;

public class Menu {
	private static final Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) {
		int opcao;
		
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
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todos os Produtos\n\n");
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Buscar Produto por Id\n\n");		
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar Produto\n\n");	
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Deletar Produto\n\n");
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
}
