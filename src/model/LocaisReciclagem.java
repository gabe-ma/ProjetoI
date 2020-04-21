package model;

public class LocaisReciclagem {

	private String rua;
	private int numero;
	private String bairro;
	private String telefone;
	private int quantLixo;
	private int idLixoReciclado;
	
	public LocaisReciclagem(String rua, int numero, String bairro, String telefone, int quantLixo,
			int idLixoReciclado) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.telefone = telefone;
		this.quantLixo = quantLixo;
		this.idLixoReciclado = idLixoReciclado;
	}
	
	public LocaisReciclagem() {
		
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getQuantLixo() {
		return quantLixo;
	}

	public void setQuantLixo(int quantLixo) {
		this.quantLixo = quantLixo;
	}

	public int getIdLixoReciclado() {
		return idLixoReciclado;
	}

	public void setIdLixoReciclado(int idLixoReciclado) {
		this.idLixoReciclado = idLixoReciclado;
	}
	
}
