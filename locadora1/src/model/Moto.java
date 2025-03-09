package model;

public class Moto extends Veiculo {
	
	public Moto(String modelo, String placa) {
		super(modelo, placa);
	}

	@Override
	public String getTipo() {
		return "Moto";
	}

	@Override
	public double custoLocacao(int dias) {
		return dias * 50.0;
	}
}
