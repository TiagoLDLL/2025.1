package repositorios;

import java.util.ArrayList;

import entidades.Instrumento;

public class RepositorioInstrumento {

	ArrayList<Instrumento> REPOSITORIO = new ArrayList<>();
	
	public void adicionar(Instrumento INSTRUMENTO) {
		REPOSITORIO.add(INSTRUMENTO);
	}
	
	public void remover(int INDEX) {
		REPOSITORIO.remove(INDEX);
	}
	
	public void modificar(int INDEX, Instrumento INSTRUMENTO) {
		REPOSITORIO.set(INDEX, INSTRUMENTO);
	}
	
	public void listar() {
		System.out.println();
		for(int i=0; i<REPOSITORIO.size(); i++) {
			System.out.println("["+(i+1)+"]\n"+REPOSITORIO.get(i).toString());
		}
	}
	
	public int tamanho() {
		return REPOSITORIO.size();
	}
}
