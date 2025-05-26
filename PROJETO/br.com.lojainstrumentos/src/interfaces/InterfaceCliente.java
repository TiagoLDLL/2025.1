package interfaces;

import java.util.List;
import entidades.Cliente;

public interface InterfaceCliente {

	void adicionarCliente();
	void removerCliente();
	void modificarCliente();
	List<Cliente> listarCliente();
	
}
