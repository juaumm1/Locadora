package model;

public abstract class Veiculo {
	public String modelo;
	public String placa;
	public boolean disponivel;

	public Veiculo(String modelo, String placa) {
	        this.modelo = modelo;
	        this.placa = placa;
	        this.disponivel = true;
	    }
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	public abstract String getTipo();

	public abstract double custoLocacao(int dias);

	@Override
	public String toString() {
		return getTipo() + ": " + modelo + " - " + placa + (disponivel ? " (Disponível)" : " (Alugado)");
	}
}
