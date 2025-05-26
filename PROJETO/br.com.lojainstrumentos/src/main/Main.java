package main;

import servicos.ServicoInstrumento;
import servicos.ServicoCliente;

public class Main {

	final static InputManager INPUT = new InputManager();
	final static ServicoInstrumento SERVICOS_INSTRUMENTO = new ServicoInstrumento();
	final static ServicoCliente SERVICOS_CLIENTE = new ServicoCliente();
	
	public static void main (String[] args) {
	
		menu();
		while(true) {
			
			int OPCAO = INPUT.getInt();
			
			switch(OPCAO) {
			
			case 0:
			System.out.println("\nPrograma desligado.");
			System.exit(0);
			
			case 1:
			SERVICOS_INSTRUMENTO.adicionarInstrumento();
			menu();
			break;
				
			case 2:
			SERVICOS_INSTRUMENTO.removerInstrumento();
			menu();
			break;
				
			case 3:
			SERVICOS_INSTRUMENTO.modificarInstrumento();
			menu();
			break;
				
			case 4:
			SERVICOS_INSTRUMENTO.listarInstrumento();
			menu();
			break;
			
			case 5:
			SERVICOS_CLIENTE.adicionarCliente();
			menu();
			break;
			
			case 6:
			SERVICOS_CLIENTE.removerCliente();
			menu();
			break;
			
			case 7:
			SERVICOS_CLIENTE.modificarCliente();
			menu();
			break;
			
			case 8:
			SERVICOS_CLIENTE.listarCliente();
			menu();
			break;
					
			default:
			System.out.print("\nOpção inválida, tente novamente: ");
			break;
			}
		}
	}
	
	public static void menu() {
		System.out.println("       ▼ LOJA DE INSTRUMENTOS MUSICAIS ▼\n");
		System.out.println("[1] Adicionar Instrumento     [5] Adicionar Cliente     [0] Sair");
		System.out.println("[2] Remover Instrumento       [6] Remover Cliente");
		System.out.println("[3] Modificar Instrumento     [7] Modificar Cliente");
		System.out.println("[4] Listar Instrumentos       [8] Listar Clientes");
		System.out.print("\nSelecione a opção: ");
	}

}
