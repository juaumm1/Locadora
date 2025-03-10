package model;

public class Cliente {
	public String nome;
	public String cpf;
	public String numero;
	public String email;

	public Cliente(String nome, String cpf, String numero, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.numero = numero;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return nome + " (CPF: " + cpf + ", Tel: " + numero + ", Email: " + email + ")";
	}
}
