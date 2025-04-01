package entidades;

public class Instrumento {

	private String nome;
	private double preco;
	private String marca;
	private String modelo;
	
	public Instrumento(String nome, double preco, String marca, String modelo) {
		this.nome = nome;
		this.preco = preco;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
	
	public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    @Override
    public String toString() {
    	return 	"Instrumento: "+nome+"\n"+
    			"Preço: "+preco+"\n"+
    			"Marca: "+marca+"\n"+
    			"Modelo: "+modelo+"\n";
    }
    
}
