package servicos;

import interfaces.InterfaceCliente;
import main.InputManager;
import entidades.Cliente;
import repositorios.RepositorioCliente;

public class ServicoCliente extends InputManager implements InterfaceCliente{

	RepositorioCliente repositorioCliente = new RepositorioCliente();
	
	@Override
	public void adicionarCliente() {
		repositorioCliente.adicionar(getCliente());
		System.out.println("\nCliente adicionado com sucesso.\n");
	}

	@Override
	public void removerCliente() {
		if(repositorioCliente.tamanho() == 0) {
			System.out.println("\nNão existe nenhum cliente cadastrado no momento.\n");
			return;
		}
		repositorioCliente.listar();
		System.out.print("Insira a opção que deseja remover. [0] Cancelar: ");
		while(true) {
			int opcao = getInt();
			if(opcao == 0) {
				System.out.println();
				return;
			}
			if(opcao > repositorioCliente.tamanho()) {
				System.out.print("\nOpção inválida, tente novamente: ");
				continue;
			}
			repositorioCliente.remover(opcao-1);
			System.out.println("\nCliente removido com sucesso.\n");
			break;
		}
	}

	@Override
	public void modificarCliente() {
		if(repositorioCliente.tamanho() == 0) {
			System.out.println("\nNão existe nenhum cliente cadastrado no momento.\n");
			return;
		}
		repositorioCliente.listar();
		System.out.print("Insira a opção que deseja modificar. [0] Cancelar: ");
		while(true) {
			int opcao = getInt();
			if(opcao == 0) {
				System.out.println();
				return;
			}
			if(opcao > repositorioCliente.tamanho()) {
				System.out.print("\nOpção inválida, tente novamente: ");
				continue;
			}
			repositorioCliente.modificar(opcao-1, getCliente());
			System.out.println("\nCliente modificado com sucesso.\n");
			break;
		}
	}

	@Override
	public void listarCliente() {
		if(repositorioCliente.tamanho() == 0) {
			System.out.println("\nNão existe nenhum cliente cadastrado no momento.\n");
			return;
		}
		repositorioCliente.listar();
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
