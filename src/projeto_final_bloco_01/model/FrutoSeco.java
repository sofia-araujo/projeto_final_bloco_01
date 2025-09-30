package projeto_final_bloco_01.model;

public class FrutoSeco extends Produto{
	private int tipoFruto;
	
	public FrutoSeco(int id, String nome, float preco, int categoria, int tipoFruto) {
		super(id, nome, preco, categoria);
		this.tipoFruto = tipoFruto;
	}

	public int getTipoFruto() {
		return tipoFruto;
	}

	public void setTipoFruto(int tipoFruto) {
		this.tipoFruto = tipoFruto;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		
		String tipoFruto = " ";
		
		switch(this.tipoFruto) {
			case 1 -> tipoFruto = "Castanha";
			case 2 -> tipoFruto = "Noz";
			case 3 -> tipoFruto = "Amêndoa";
			default -> tipoFruto = "Inválido";
		}
		
		System.out.printf("Tipo do fruto: %s%n", tipoFruto);
	}
}
