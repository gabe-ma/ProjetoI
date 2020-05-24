package model;

public class Usuarios {

	private int idUsuario;
	private String nome;
	private String email;
	private String senha;
	private int tipoUsuario;
	private int contaBancaria;
	private int carteira;

	public Usuarios() {

	}

	public Usuarios(String nome, String email, String senha, int tipoUsuario, int contaBancaria, int carteira) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
		this.contaBancaria = contaBancaria;
		this.carteira = carteira;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public int getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(int contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public int getCarteira() {
		return carteira;
	}

	public void setCarteira(int carteira) {
		this.carteira = carteira;
	}
	

}
