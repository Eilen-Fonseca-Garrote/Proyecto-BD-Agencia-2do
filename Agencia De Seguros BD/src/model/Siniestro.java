package model;

public class Siniestro {
	private int idSiniestro;
    private String tipoSiniestro;
    
	public Siniestro(int idSiniestro, String tipoSiniestro) {
		super();
		this.idSiniestro = idSiniestro;
		this.tipoSiniestro = tipoSiniestro;
	}

	public Siniestro() {
		// TODO Auto-generated constructor stub
	}

	public int getIdSiniestro() {
		return idSiniestro;
	}

	public void setIdSiniestro(int idSiniestro) {
		this.idSiniestro = idSiniestro;
	}

	public String getTipoSiniestro() {
		return tipoSiniestro;
	}

	public void setTipoSiniestro(String tipoSiniestro) {
		this.tipoSiniestro = tipoSiniestro;
	}
	
	
    
    

}
