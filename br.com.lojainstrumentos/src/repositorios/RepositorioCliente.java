package repositorios;

import java.util.ArrayList;

import entidades.Cliente;

public class RepositorioCliente {

	public final ArrayList<Cliente> REPOSITORIO = new ArrayList<>();
	
	public void adicionar(Cliente CLIENTE) {
		REPOSITORIO.add(CLIENTE);
	}
	
	public void remover(int INDEX) {
		REPOSITORIO.remove(INDEX);
	}
	
	public void modificar(int INDEX, Cliente CLIENTE) {
		REPOSITORIO.set(INDEX, CLIENTE);
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
