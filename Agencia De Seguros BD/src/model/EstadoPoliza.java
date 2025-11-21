package model;

public class EstadoPoliza {
	 private int idEstadoPoliza;
	 private String tipoPoliza;
	 private String motivo;
	 
	public EstadoPoliza(int idEstadoPoliza, String tipoPoliza, String motivo) {
		super();
		this.idEstadoPoliza = idEstadoPoliza;
		this.tipoPoliza = tipoPoliza;
		this.motivo = motivo;
	}

	public EstadoPoliza() {
		// TODO Auto-generated constructor stub
	}

	public int getIdEstadoPoliza() {
		return idEstadoPoliza;
	}

	public void setIdEstadoPoliza(int idEstadoPoliza) {
		this.idEstadoPoliza = idEstadoPoliza;
	}

	public String getTipoPoliza() {
		return tipoPoliza;
	}

	public void setTipoPoliza(String tipoPoliza) {
		this.tipoPoliza = tipoPoliza;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	 
	 
	    

}
