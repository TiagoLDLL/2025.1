package servicos;

import interfaces.InterfaceInstrumento;
import entidades.Instrumento;
import repositorios.RepositorioInstrumento;
import main.InputManager;

public class ServicoInstrumento extends InputManager implements InterfaceInstrumento {

	RepositorioInstrumento repositorioInstrumento = new RepositorioInstrumento();
	
	@Override
	public void adicionarInstrumento() {
		repositorioInstrumento.adicionar(getInstrumento());
		System.out.println("\nInstrumento adicionado com sucesso.\n");
	}

	@Override
	public void removerInstrumento() {
		if(repositorioInstrumento.tamanho() == 0) {
			System.out.println("\nNão existe nenhum instrumento na loja no momento.\n");
			return;
		}
		repositorioInstrumento.listar();
		System.out.print("Insira a opção que deseja remover. [0] Cancelar: ");
		while(true) {
			int opcao = getInt();
			if(opcao == 0) {
				System.out.println();
				return;
			}
			if(opcao > repositorioInstrumento.tamanho()) {
				System.out.print("\nOpção inválida, tente novamente: ");
				continue;
			}
			repositorioInstrumento.remover(opcao-1);
			System.out.println("\nInstrumento removido com sucesso.\n");
			break;
		}
	}

	@Override
	public void modificarInstrumento() {
		if(repositorioInstrumento.tamanho() == 0) {
			System.out.println("\nNão existe nenhum instrumento na loja no momento.\n");
			return;
		}
		repositorioInstrumento.listar();
		System.out.print("Insira a opção que deseja modificar. [0] Cancelar: ");
		while(true) {
			int opcao = getInt();
			if(opcao == 0) {
				System.out.println();
				return;
			}
			if(opcao > repositorioInstrumento.tamanho()) {
				System.out.print("\nOpção inválida, tente novamente: ");
				continue;
			}
			repositorioInstrumento.modificar(opcao-1, getInstrumento());
			System.out.println("\nInstrumento modificado com sucesso.\n");
			break;
		}
	}

	@Override
	public void listarInstrumento() {
		if(repositorioInstrumento.tamanho() == 0) {
			System.out.println("\nNão existe nenhum instrumento na loja no momento.\n");
			return;
		}
		repositorioInstrumento.listar();
	}
	
	private Instrumento getInstrumento() {	
		System.out.print("\nInsira o nome do instrumento: ");
		String nome = getString();	
		System.out.print("\nInsira a marca do instrumento: ");
		String marca = getString();
		System.out.print("\nInsira o modelo do instrumento: ");
		String modelo = getString();
		System.out.print("\nInsira o preço do instrumento: ");
		double preco = getDouble();
		return new Instrumento(nome, preco, marca, modelo);
	}
}
