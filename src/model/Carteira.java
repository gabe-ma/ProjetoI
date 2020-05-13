package model;

public class Carteira {

	private Double saldo;

	public Carteira(Double saldo) {
		super();
		this.saldo = saldo;
	}
	
	public Carteira() {
		
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
}
