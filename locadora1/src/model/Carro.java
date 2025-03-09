package model;

public class Carro extends Veiculo {

	public Carro(String modelo, String placa) {
		super(modelo, placa);
	}

	@Override
	public String getTipo() {
		return "Carro";
	}

	@Override
	public double custoLocacao(int dias) {
		return dias * 100.0;
	}
}
