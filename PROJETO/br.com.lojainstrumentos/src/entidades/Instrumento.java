package entidades;

public class Instrumento extends Produto{
	
	private int id;
	private String marca;
	private String modelo;
	
	public Instrumento(String nome, double preco, String marca, String modelo) {
		super(nome,preco);
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public int getId() {
    	return id;
    }
    
    @Override
    public String toString() {
    	return 	"Instrumento: "+getNome()+"\n"+
    			"Preço: "+getPreco()+"\n"+
    			"Marca: "+getMarca()+"\n"+
    			"Modelo: "+getModelo()+"\n";
    }
    
}
