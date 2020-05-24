package model;

public class TipoDeLixo {

	private int id;
	private String tipo_de_lixo;
	
	public TipoDeLixo(int id){
		this.id = id;
	}
	
	public TipoDeLixo(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo_de_lixo() {
		return tipo_de_lixo;
	}

	public void setTipo_de_lixo(String tipo_de_lixo) {
		this.tipo_de_lixo = tipo_de_lixo;
	}
	
}
