package projeto_final_bloco_01.model;

public class Tempero extends Produto{
	private String sabor;
	private String origem;
	
	public Tempero(int id, String nome, float preco, int categoria, String sabor, String origem) {
		super(id, nome, preco, categoria);
		this.sabor = sabor;
		this.origem = origem;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		
		System.out.printf("Sabor: %s%n", this.sabor);
		System.out.printf("Origem (País): %s%n", this.origem);
	}
}
