package model;

public class Cobertura {

	private int idCobertura;
	private String tipoCobertura;
	
	
	public Cobertura() {
		super();
	}

	public Cobertura(int idCobertura, String tipoCobertura) {
		super();
		this.idCobertura = idCobertura;
		this.tipoCobertura = tipoCobertura;
	}

	public int getIdCobertura() {
		return idCobertura;
	}

	public void setIdCobertura(int idCobertura) {
		this.idCobertura = idCobertura;
	}

	public String getTipoCobertura() {
		return tipoCobertura;
	}

	public void setTipoCobertura(String tipoCobertura) {
		this.tipoCobertura = tipoCobertura;
	}
	
}
