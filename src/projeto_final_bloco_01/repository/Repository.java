package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Produto;

public interface Repository {
	
		public void listarTodas();
		public void cadastrar(Produto produto);
		public void atualizar(Produto produto);
		public void procurarPorId(int id);
		public void deletar(int id);

}
