package repositorios;

import java.util.ArrayList;
import entidades.Instrumento;

public class RepositorioInstrumento {

	// Depois de migrar para o Banco de Dados MySQL, acredito que essa classe de repositório esteja completamente inútil no código.
	// Porém, eu decidi manter por que talvez me venha ser útil no futuro para outros fins.
	// Dito isso, o mesmo vale para o Repositório de Clientes.
	
	ArrayList<Instrumento> repositorio = new ArrayList<>();
	
	public void adicionar(Instrumento instrumento) {
		repositorio.add(instrumento);
	}
	
	public void remover(int index) {
		repositorio.remove(index);
	}
	
	public void modificar(int index, Instrumento instrumento) {
		repositorio.set(index, instrumento);
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
