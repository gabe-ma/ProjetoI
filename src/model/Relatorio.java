package model;

public class Relatorio {
	
	private int idRelatorio;
	private String Bairro;
	private int qntLixo;
	private int maiorTipoLixo;
	private String descricao;
	private TipoDeLixo tipoLixo;
	
	public Relatorio() {
		
	}

	public Relatorio(int idRelatorio, String bairro, int qntLixo, int maiorTipoLixo, String descricao, TipoDeLixo tipoLixo) {
		super();
		this.idRelatorio = idRelatorio;
		Bairro = bairro;
		this.qntLixo = qntLixo;
		this.maiorTipoLixo = maiorTipoLixo;
		this.descricao = descricao;
		this.tipoLixo = tipoLixo;
	}

	public int getIdRelatorio() {
		return idRelatorio;
	}

	public void setIdRelatorio(int idRelatorio) {
		this.idRelatorio = idRelatorio;
	}

	public String getBairro() {
		return Bairro;
	}

	public void setBairro(String bairro) {
		Bairro = bairro;
	}

	public int getQntLixo() {
		return qntLixo;
	}

	public void setQntLixo(int qntLixo) {
		this.qntLixo = qntLixo;
	}

	public int getMaiorTipoLixo() {
		return maiorTipoLixo;
	}

	public void setMaiorTipoLixo(int maiorTipoLixo) {
		this.maiorTipoLixo = maiorTipoLixo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoDeLixo getTipoLixo() {
		return tipoLixo;
	}

	public void setTipoLixo(TipoDeLixo tipoLixo) {
		this.tipoLixo = tipoLixo;
	}
	
}
