package model;

public class Caminhao extends Veiculo {
	
	public Caminhao(String modelo, String placa) {
		super(modelo, placa);
	}

	@Override
	public String getTipo() {
		return "Caminhão";
	}

	@Override
	public double custoLocacao(int dias) {
		return dias * 300.0;
	}
}
