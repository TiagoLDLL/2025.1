package entidades;

public class Cliente {

	private int idade, id;
	private String nome, cpf, email, telefone;
	
	public Cliente(int idade, String nome, String cpf, String email, String telefone) {
		this.idade = idade;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	@Override
	public String toString() {
		return  "Nome: "+nome+"\n"+
				"Email: "+email+"\n"+
				"CPF: "+cpf+"\n"+
				"Telefone: "+telefone+"\n"+
				"Idade: "+idade+"\n"+
				"ID: "+id+"\n";
	}
	
}
