package servicos;

import interfaces.InterfaceInstrumento;
import entidades.Instrumento;
import repositorios.RepositorioInstrumento;
import main.InputManager;

import java.util.Collections;
import java.util.List;

import dal.InstrumentoDAO;

public class ServicoInstrumento extends InputManager implements InterfaceInstrumento {

	RepositorioInstrumento repositorioInstrumento = new RepositorioInstrumento();
	InstrumentoDAO instrumentoDAO = new InstrumentoDAO();
	
	@Override
	public void adicionarInstrumento() {
		Instrumento novoInstrumento = getInstrumento();
		repositorioInstrumento.adicionar(novoInstrumento);
		boolean adicionar = instrumentoDAO.salvar(novoInstrumento);
		if(adicionar) {
			System.out.println("\nInstrumento adicionado com sucesso.\n");
		} else {
			System.out.println("\nFalha ao adicionar instrumento.\n");
		}
		
	}

	@Override
	public void removerInstrumento() {
		List<Instrumento> instrumentos = listarInstrumento();
	    if (instrumentos.isEmpty()) {
	        return;
	    }
	    System.out.print("Insira a opção que deseja remover. [0] Cancelar: ");
	    while (true) {
	    	int opcao = getInt();
	        if (opcao == 0) {
	            System.out.println();
	            return;
	        }
	        if (opcao < 1 || opcao > instrumentos.size()) {
	            System.out.print("\nOpção inválida, tente novamente: ");
	            continue;
	        }
	        Instrumento instSelecionado = instrumentos.get(opcao - 1);
	        boolean sucesso = instrumentoDAO.remover(instSelecionado.getId());

	        if (sucesso) {
	            System.out.println("\nInstrumento removido com sucesso.\n");
	        } else {
	            System.out.println("\nErro ao remover instrumento no banco.\n");
	        }
	        break;
	    }
	}

	@Override
	public void modificarInstrumento() {
	    List<Instrumento> instrumentos = listarInstrumento();
	    if (instrumentos.isEmpty()) {
	        return;
	    }

	    System.out.print("Insira a opção que deseja modificar. [0] Cancelar: ");
	    while (true) {
	        int opcao = getInt();
	        if (opcao == 0) {
	            System.out.println();
	            return;
	        }
	        if (opcao < 1 || opcao > instrumentos.size()) {
	            System.out.print("\nOpção inválida, tente novamente: ");
	            continue;
	        }
	        Instrumento instOriginal = instrumentos.get(opcao - 1);
	        Instrumento instAtualizado = getInstrumento();
	        boolean sucesso = instrumentoDAO.atualizar(instOriginal.getId(), instAtualizado);
	        if (sucesso) {
	            System.out.println("\nInstrumento modificado com sucesso.\n");
	        } else {
	            System.out.println("\nErro ao modificar instrumento no banco.\n");
	        }
	        break;
	    }
	}

	@Override
	public List<Instrumento> listarInstrumento() {
	    List<Instrumento> instrumentos = instrumentoDAO.listarTodos();
	    if (instrumentos.isEmpty()) {
	        System.out.println("\nNão existe nenhum instrumento na loja no momento.\n");
	        return Collections.emptyList();
	    }

	    for (int i = 0; i < instrumentos.size(); i++) {
	        Instrumento inst = instrumentos.get(i);
	        System.out.println("[" + (i + 1) + "] Instrumento: " + inst.getNome());
	        System.out.println("Marca: " + inst.getMarca());
	        System.out.println("Modelo: " + inst.getModelo());
	        System.out.println("Preço: " + inst.getPreco() + "0R$");
	        System.out.println();
	    }

	    return instrumentos;
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
