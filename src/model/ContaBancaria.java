package model;

public class ContaBancaria {

	private int idConta;
	private String banco;
	private String conta;
	private String agencia;
	
	public ContaBancaria() {
		
	}
	
	public ContaBancaria(int idConta, String banco, String conta, String agencia) {
		super();
		this.idConta = idConta;
		this.banco = banco;
		this.conta = conta;
		this.agencia = agencia;
	}

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
}
