package model;

public class CompaniaReaseg {
	private int idCompania;
    private String nombreCompania;
    private String paisOrigen;
    private String tipoReaseg;
    private double porcentajeParticipacion;
    private int idAgencia; // Clave foránea a AgenciaSeguro
    
	public CompaniaReaseg(int idCompania, String nombreCompania,
			String paisOrigen, String tipoReaseg,
			double porcentajeParticipacion, int idAgencia) {
		super();
		this.idCompania = idCompania;
		this.nombreCompania = nombreCompania;
		this.paisOrigen = paisOrigen;
		this.tipoReaseg = tipoReaseg;
		this.porcentajeParticipacion = porcentajeParticipacion;
		this.idAgencia = idAgencia;
	}
	
	
	public CompaniaReaseg() {
		// TODO Auto-generated constructor stub
	}


	public int getIdCompania() {
		return idCompania;
	}
	public void setIdCompania(int idCompania) {
		this.idCompania = idCompania;
	}
	public String getNombreCompania() {
		return nombreCompania;
	}
	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}
	public String getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	public String getTipoReaseg() {
		return tipoReaseg;
	}
	public void setTipoReaseg(String tipoReaseg) {
		this.tipoReaseg = tipoReaseg;
	}
	public double getPorcentajeParticipacion() {
		return porcentajeParticipacion;
	}
	public void setPorcentajeParticipacion(double porcentajeParticipacion) {
		this.porcentajeParticipacion = porcentajeParticipacion;
	}
	public int getIdAgencia() {
		return idAgencia;
	}
	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}


}
