package entidades;

public class Instrumento {

	private String NOME;
	private double PRECO;
	private String MARCA;
	private String MODELO;
	
	public Instrumento(String NOME, double PRECO, String MARCA, String MODELO) {
		this.NOME = NOME;
		this.PRECO = PRECO;
		this.MARCA = MARCA;
		this.MODELO = MODELO;
	}
	
	public String getNome() {
		return NOME;
	}
	
	public void setNome(String NOME) {
		this.NOME = NOME;
	}
	
	public String getModelo() {
        return MODELO;
    }

    public void setModelo(String MODELO) {
        this.MODELO = MODELO;
    }
	
	public double getPreco() {
        return PRECO;
    }

    public void setPreco(double PRECO) {
        this.PRECO = PRECO;
    }

    public String getMarca() {
        return MARCA;
    }

    public void setMarca(String MARCA) {
        this.MARCA = MARCA;
    }
    
    @Override
    public String toString() {
    	return 	"Instrumento: "+NOME+"\n"+
    			"Preço: "+PRECO+"\n"+
    			"Marca: "+MARCA+"\n"+
    			"Modelo: "+MODELO+"\n";
    }
    
}
