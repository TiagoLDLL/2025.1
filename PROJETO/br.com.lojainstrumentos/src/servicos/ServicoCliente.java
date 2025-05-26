package servicos;

import interfaces.InterfaceCliente;
import main.InputManager;
import entidades.Cliente;
import dal.ClienteDAO;
import java.util.List;

public class ServicoCliente extends InputManager implements InterfaceCliente{

    private ClienteDAO clienteDAO = new ClienteDAO();

    @Override
    public void adicionarCliente() {
        Cliente cliente = getCliente();
        if (clienteDAO.salvar(cliente)) {
            System.out.println("\nCliente adicionado com sucesso.\n");
        } else {
            System.out.println("\nFalha ao adicionar cliente.\n");
        }
    }

    @Override
    public void removerCliente() {
        List<Cliente> clientes = listarCliente();
        if (clientes.isEmpty()) {
            System.out.println("\nNão existe nenhum cliente cadastrado no momento.\n");
            return;
        }
        System.out.print("Insira a opção que deseja remover. [0] Cancelar: ");
        while (true) {
            int opcao = getInt();
            if (opcao == 0) {
                System.out.println();
                return;
            }
            if (opcao > clientes.size() || opcao < 0) {
                System.out.print("\nOpção inválida, tente novamente: ");
                continue;
            }
            Cliente cliente = clientes.get(opcao - 1);
            if (clienteDAO.remover(cliente.getId())) {
                System.out.println("\nCliente removido com sucesso.\n");
            } else {
                System.out.println("\nFalha ao remover cliente.\n");
            }
            break;
        }
    }

    @Override
    public void modificarCliente() {
        List<Cliente> clientes = listarCliente();
        if (clientes.isEmpty()) {
            System.out.println("\nNão existe nenhum cliente cadastrado no momento.\n");
            return;
        }
        System.out.print("Insira a opção que deseja modificar. [0] Cancelar: ");
        while (true) {
            int opcao = getInt();
            if (opcao == 0) {
                System.out.println();
                return;
            }
            if (opcao > clientes.size() || opcao < 0) {
                System.out.print("\nOpção inválida, tente novamente: ");
                continue;
            }
            Cliente cliente = clientes.get(opcao - 1);
            Cliente novoCliente = getCliente();
            if (clienteDAO.atualizar(cliente.getId(), novoCliente)) {
                System.out.println("\nCliente modificado com sucesso.\n");
            } else {
                System.out.println("\nFalha ao modificar cliente.\n");
            }
            break;
        }
    }

    @Override
    public List<Cliente> listarCliente() {
        List<Cliente> clientes = clienteDAO.listarTodos();
        if (clientes.isEmpty()) {
            System.out.println("\nNão existe nenhum cliente cadastrado no momento.\n");
        } else {
            for (int i = 0; i < clientes.size(); i++) {
                Cliente c = clientes.get(i);
                System.out.println("[" + (i + 1) + "] " + c);
            }
        }
        return clientes;
    }
	
	private Cliente getCliente() {
		System.out.print("\nDigite o nome do cliente: ");
		String nome = getString();
		System.out.print("\nDigite a idade do cliente: ");
		int idade = getInt();
		System.out.print("\nDigite o email do cliente: ");
		String email = getEmail();
		System.out.print("\nDigite o CPF do cliente: ");
		String cpf = getCpf();
		System.out.print("\nDigite o telefone do cliente: ");
		String telefone = getTelefone();
		return new Cliente(idade, nome, cpf, email, telefone);
	}
	
	private String getEmail() {
		while(true) {
			String email = getString();
			if(email.contains("@") && email.contains(".com")) {
				return email;
			}
			System.out.print("\nEmail inválido, tente novamente: ");
		}
	}
	
	private String getCpf() {
		while(true) {
			String cpf = getString();
			if(cpf.length() == 11 && cpf.matches("[0-9]+")) {
				return cpf;
			}
			System.out.print("\nCPF inválido, tente novamente: ");
		}
	}
	
	private String getTelefone() {
		while(true) {
			String telefone = getString();
			if(telefone.length() == 13 || telefone.length() == 11 || telefone.length() == 9 || telefone.length() == 8) {
				if(telefone.matches("[0-9]+")) {
					return telefone;
				}
			}
			System.out.print("\nTelefone inválido, tente novamente: ");
		}
	}
	
}
