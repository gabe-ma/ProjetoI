package model;

public class Carteira {

	private int idCarteira;
	private Double saldo;

	public Carteira(int idCarteira, Double saldo) {
		super();
		this.idCarteira = idCarteira;
		this.saldo = saldo;
	}
	
	public Carteira() {
		
	}

	public int getIdCarteira() {
		return idCarteira;
	}

	public void setIdCarteira(int idCarteira) {
		this.idCarteira = idCarteira;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
}
