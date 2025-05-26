package interfaces;

import java.util.List;
import entidades.Instrumento;

public interface InterfaceInstrumento {

	void adicionarInstrumento();
	void removerInstrumento();
	void modificarInstrumento();
	List<Instrumento> listarInstrumento();
	
}
