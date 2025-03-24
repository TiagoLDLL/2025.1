package servicos;

import interfaces.InterfaceInstrumento;
import entidades.Instrumento;
import repositorios.RepositorioInstrumento;
import main.InputManager;

public class ServicoInstrumento extends InputManager implements InterfaceInstrumento {

	RepositorioInstrumento REPOSITORIO_INSTRUMENTO = new RepositorioInstrumento();
	
	@Override
	public void adicionarInstrumento() {
		REPOSITORIO_INSTRUMENTO.adicionar(getInstrumento());
		System.out.println("\nInstrumento adicionado com sucesso.\n");
	}

	@Override
	public void removerInstrumento() {
		if(REPOSITORIO_INSTRUMENTO.tamanho() == 0) {
			System.out.println("\nNão existe nenhum instrumento na loja no momento.\n");
			return;
		}
		REPOSITORIO_INSTRUMENTO.listar();
		System.out.print("Insira a opção que deseja remover. [0] Cancelar: ");
		while(true) {
			int OPCAO = getInt();
			if(OPCAO == 0) {
				System.out.println();
				return;
			}
			if(OPCAO > REPOSITORIO_INSTRUMENTO.tamanho()) {
				System.out.print("\nOpção inválida, tente novamente: ");
				continue;
			}
			REPOSITORIO_INSTRUMENTO.remover(OPCAO-1);
			System.out.println("\nInstrumento removido com sucesso.\n");
			break;
		}
	}

	@Override
	public void modificarInstrumento() {
		if(REPOSITORIO_INSTRUMENTO.tamanho() == 0) {
			System.out.println("\nNão existe nenhum instrumento na loja no momento.\n");
			return;
		}
		REPOSITORIO_INSTRUMENTO.listar();
		System.out.print("Insira a opção que deseja modificar. [0] Cancelar: ");
		while(true) {
			int OPCAO = getInt();
			if(OPCAO == 0) {
				System.out.println();
				return;
			}
			if(OPCAO > REPOSITORIO_INSTRUMENTO.tamanho()) {
				System.out.print("\nOpção inválida, tente novamente: ");
				continue;
			}
			REPOSITORIO_INSTRUMENTO.modificar(OPCAO-1, getInstrumento());
			System.out.println("\nInstrumento modificado com sucesso.\n");
			break;
		}
	}

	@Override
	public void listarInstrumento() {
		if(REPOSITORIO_INSTRUMENTO.tamanho() == 0) {
			System.out.println("\nNão existe nenhum instrumento na loja no momento.\n");
			return;
		}
		REPOSITORIO_INSTRUMENTO.listar();
	}
	
	private Instrumento getInstrumento() {	
		System.out.print("\nInsira o nome do instrumento: ");
		String NOME_INSTRUMENTO = getString();	
		System.out.print("\nInsira a marca do instrumento: ");
		String MARCA_INSTRUMENTO = getString();
		System.out.print("\nInsira o modelo do instrumento: ");
		String MODELO_INSTRUMENTO = getString();
		System.out.print("\nInsira o preço do instrumento: ");
		double PRECO_INSTRUMENTO = getDouble();
		return new Instrumento(NOME_INSTRUMENTO, PRECO_INSTRUMENTO, MARCA_INSTRUMENTO, MODELO_INSTRUMENTO);
	}
}
