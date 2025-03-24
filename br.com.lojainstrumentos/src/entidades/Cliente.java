package entidades;

public class Cliente {

	private int IDADE, ID;
	private static int CONTADOR_ID;
	private String NOME, CPF, EMAIL, TELEFONE;
	
	public Cliente(int IDADE, String NOME, String CPF, String EMAIL, String TELEFONE) {
		this.IDADE = IDADE;
		this.ID = CONTADOR_ID++;
		this.NOME = NOME;
		this.CPF = CPF;
		this.EMAIL = EMAIL;
		this.TELEFONE = TELEFONE;
	}
	
	public void setIdade(int IDADE) {
		this.IDADE = IDADE;
	}
	
	public int setId() {
		ID++;
		return ID;
	}
	
	public void setNome(String NOME) {
		this.NOME = NOME;
	}
	
	public void setCpf(String CPF) {
		this.CPF = CPF;
	}
	
	public void setEmail(String EMAIL) {
		this.EMAIL = EMAIL;
	}

	public void setTelefone(String TELEFONE) {
		this.TELEFONE = TELEFONE;
	}
	
	public int getIdade() {
		return IDADE;
	}
	
	public int getId() {
		return ID;
	}
	
	public String getNome() {
		return NOME;
	}
	
	public String getCpf() {
		return CPF;
	}
	
	public String getEmail() {
		return EMAIL;
	}
	
	public String getTelefone() {
		return TELEFONE;
	}
	
	@Override
	public String toString() {
		return  "Nome: "+NOME+"\n"+
				"Email: "+EMAIL+"\n"+
				"CPF: "+CPF+"\n"+
				"Telefone: "+TELEFONE+"\n"+
				"Idade: "+IDADE+"\n"+
				"ID: "+ID+"\n";
	}
	
}
