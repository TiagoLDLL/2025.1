package servicos;

import interfaces.InterfaceCliente;
import main.InputManager;
import entidades.Cliente;
import repositorios.RepositorioCliente;

public class ServicoCliente extends InputManager implements InterfaceCliente{

	RepositorioCliente REPOSITORIO_CLIENTE = new RepositorioCliente();
	
	@Override
	public void adicionarCliente() {
		REPOSITORIO_CLIENTE.adicionar(getCliente());
		System.out.println("\nCliente adicionado com sucesso.\n");
	}

	@Override
	public void removerCliente() {
		if(REPOSITORIO_CLIENTE.tamanho() == 0) {
			System.out.println("\nNão existe nenhum cliente cadastrado no momento.\n");
			return;
		}
		REPOSITORIO_CLIENTE.listar();
		System.out.print("Insira a opção que deseja remover. [0] Cancelar: ");
		while(true) {
			int OPCAO = getInt();
			if(OPCAO == 0) {
				System.out.println();
				return;
			}
			if(OPCAO > REPOSITORIO_CLIENTE.tamanho()) {
				System.out.print("\nOpção inválida, tente novamente: ");
				continue;
			}
			REPOSITORIO_CLIENTE.remover(OPCAO-1);
			System.out.println("\nCliente removido com sucesso.\n");
			break;
		}
	}

	@Override
	public void modificarCliente() {
		if(REPOSITORIO_CLIENTE.tamanho() == 0) {
			System.out.println("\nNão existe nenhum cliente cadastrado no momento.\n");
			return;
		}
		REPOSITORIO_CLIENTE.listar();
		System.out.print("Insira a opção que deseja modificar. [0] Cancelar: ");
		while(true) {
			int OPCAO = getInt();
			if(OPCAO == 0) {
				System.out.println();
				return;
			}
			if(OPCAO > REPOSITORIO_CLIENTE.tamanho()) {
				System.out.print("\nOpção inválida, tente novamente: ");
				continue;
			}
			REPOSITORIO_CLIENTE.modificar(OPCAO-1, getCliente());
			System.out.println("\nCliente modificado com sucesso.\n");
			break;
		}
	}

	@Override
	public void listarCliente() {
		if(REPOSITORIO_CLIENTE.tamanho() == 0) {
			System.out.println("\nNão existe nenhum cliente cadastrado no momento.\n");
			return;
		}
		REPOSITORIO_CLIENTE.listar();
	}

	//===== ===== ===== ===== ======
	
	private Cliente getCliente() {
		System.out.print("\nDigite o nome do cliente: ");
		String NOME = getString();
		System.out.print("\nDigite a idade do cliente: ");
		int IDADE = getInt();
		System.out.print("\nDigite o email do cliente: ");
		String EMAIL = getEmail();
		System.out.print("\nDigite o CPF do cliente: ");
		String CPF = getCpf();
		System.out.print("\nDigite o telefone do cliente: ");
		String TELEFONE = getTelefone();
		return new Cliente(IDADE, NOME, CPF, EMAIL, TELEFONE);
	}
	
	private String getEmail() {
		while(true) {
			String EMAIL = getString();
			if(EMAIL.contains("@") && EMAIL.contains(".com")) {
				return EMAIL;
			}
			System.out.print("\nEmail inválido, tente novamente: ");
		}
	}
	
	private String getCpf() {
		while(true) {
			String CPF = getString();
			if(CPF.length() == 11 && CPF.matches("[0-9]+")) {
				return CPF;
			}
			System.out.print("\nCPF inválido, tente novamente: ");
		}
	}
	
	private String getTelefone() {
		while(true) {
			String TELEFONE = getString();
			if(TELEFONE.length() == 13 || TELEFONE.length() == 11 || TELEFONE.length() == 9 || TELEFONE.length() == 8) {
				if(TELEFONE.matches("[0-9]+")) {
					return TELEFONE;
				}
			}
			System.out.print("\nTelefone inválido, tente novamente: ");
		}
	}
	
}
