package AVLTest;

import java.util.Scanner;

public class Estoque {
	private int codigoProduto;
	private String nome;
	private int qtd;
	private float valorUnitario;

	public Estoque(Scanner scanner) {
		System.out.print("Informe o código do produto: ");
		int codigoProduto = scanner.nextInt();
		this.codigoProduto = codigoProduto;
		System.out.print("Informe o nome do produto: ");
		scanner.nextLine(); // Limpar o buffer
		String nomeProduto = scanner.nextLine();
		this.nome = nomeProduto;
		System.out.print("Informe a quantidade: ");
		int quantidade = scanner.nextInt();
		this.qtd = quantidade;
		System.out.print("Informe o valor unitário (em R$): ");
		float valorUnitario = scanner.nextFloat();
		this.valorUnitario = valorUnitario;
	}

	public Estoque(int codigoProduto, String nome, int qtd, float valorUnitario) {
		this.codigoProduto = codigoProduto;
		this.nome = nome;
		this.qtd = qtd;
		this.valorUnitario = valorUnitario;
	}

	public void setCodigoProtduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public int getQtd() {
		return qtd;
	}

	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public float getValorUnitario(){
		return valorUnitario;
	}

	@Override
	public String toString() { 
		return "Código do Produto: " + codigoProduto +
				"\nNome do Produto: " + nome +
				"\nQuantidade: " + qtd +
				"\nPreço Unitário: R$" + valorUnitario;
	}

}
