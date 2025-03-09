package model;

public class Cliente {
	public String nome;
	public String cpf;
	public String numero;
	public String email;

	public Cliente() {
	}

	public Cliente(String nome, String cpf, String numero, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.numero = numero;
		this.email = email;
	}

	@Override
	public String toString() {
		return nome + " (CPF: " + cpf + ", Tel: " + numero + ", Email: " + email + ")";
	}
}
