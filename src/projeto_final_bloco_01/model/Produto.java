package projeto_final_bloco_01.model;

public abstract class Produto {
	private int id;
	private String nome;
	private float preco;
	private int categoria;
	
	public Produto(int id, String nome, float preco, int categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	public void visualizar() {
		
		String categoria = " ";
		
		switch(this.categoria) {
			case 1 -> categoria = "Fruto Seco";
			default -> categoria = "Inválido";
		}
		
		System.out.println("\n********************************************");
		System.out.println("Dados do Produto");
		System.out.println("********************************************");
		System.out.printf("Id do produto: %d%n", this.id);
		System.out.printf("Nome do produto: %s%n", this.nome);
		System.out.printf("Categoria do produto: %s%n", categoria);
		System.out.printf("Preço do produto: %.2f%n", this.preco);
	}
}
