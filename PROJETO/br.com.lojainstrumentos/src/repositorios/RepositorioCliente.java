package repositorios;

import java.util.ArrayList;
import entidades.Cliente;

public class RepositorioCliente {
	
	// Depois de migrar para o Banco de Dados MySQL, acredito que essa classe de repositório esteja completamente inútil no código.
	// Porém, eu decidi manter por que talvez me venha ser útil no futuro para outros fins.
	// Dito isso, o mesmo vale para o Repositório de Instrumentos.

	public final ArrayList<Cliente> repositorio = new ArrayList<>();
	
	public void adicionar(Cliente cliente) {
		repositorio.add(cliente);
	}
	
	public void remover(int index) {
		repositorio.remove(index);
	}
	
	public void modificar(int index, Cliente cliente) {
		repositorio.set(index, cliente);
	}
	
	public void listar() {
		System.out.println();
		for(int i=0; i<repositorio.size(); i++) {
			System.out.println("["+(i+1)+"]\n"+repositorio.get(i).toString());
		}
	}
	
	public int tamanho() {
		return repositorio.size();
	}
}
