package AVLTest;

import java.util.Scanner;

public class AVLTest1 {

	public static void main(String[] args) {
		AVL estoqueAVL = new AVL();
		Scanner scanner = new Scanner(System.in);

		int opcao;
		do {
			System.out.println("\n\nMenu de Opções:");
			System.out.println("1. Ler dados de um produto do estoque");
			System.out.println("2. Apresentar todos os produtos do estoque");
			System.out.println("3. Calcular valor em R$ do produto em estoque");
			System.out.println("4. Calcular valor do Estoque");
			System.out.println("5. Mostrar produtos Inferiores");
			System.out.println("6. Finalizar programa");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();
			switch (opcao) {
			case 1:
				// Ler dados de um produto do estoque e inseri-los na AVL
				Estoque novoProduto = new Estoque(scanner);
				estoqueAVL.insert(novoProduto);
				break;
			case 2:
				// Apresentar todos os produtos do estoque
				System.out.println("Produtos em ordem crescente de codigoProduto:");
				System.out.print(estoqueAVL.inOrderTraversal());
				break;
			case 3:
				// Calcular valor em R$ do produto em estoque
				System.out.print("Informe o codigo do produto que deseja calcular o valor em estoque: ");
				int CodigoToSearch = scanner.nextInt();
				estoqueAVL.calcularValorProduto(CodigoToSearch);
				break;
			case 4:
				// Calcular valor do Estoque
				float valorTotalEstoque = estoqueAVL.calcularValorEstoque();
				System.out.println("Valor total do estoque em R$: " + valorTotalEstoque);
				break;
			case 5:
				// Mostrar produtos com quantidade no estoque inferiores a um valor fornecido
				System.out.print("Informe a quantidade limite: ");
				int quantidadeLimite = scanner.nextInt();
				estoqueAVL.mostrarProdutosInferiores(quantidadeLimite);
				break;
			case 6:
				// Finalizar o programa
				System.out.println("Programa finalizado.");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}

		} while (opcao != 6);

		scanner.close();
	}


}



