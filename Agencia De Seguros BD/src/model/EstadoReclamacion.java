package model;

public class EstadoReclamacion {
	 private int idEstadoReclamacion;
	    private String tipoReclamacion;
	    private String motivo;
	    
		public EstadoReclamacion(int idEstadoReclamacion,
				String tipoReclamacion, String motivo) {
			super();
			this.idEstadoReclamacion = idEstadoReclamacion;
			this.tipoReclamacion = tipoReclamacion;
			this.motivo = motivo;
		}

		public EstadoReclamacion() {
			// TODO Auto-generated constructor stub
		}

		public int getIdEstadoReclamacion() {
			return idEstadoReclamacion;
		}

		public void setIdEstadoReclamacion(int idEstadoReclamacion) {
			this.idEstadoReclamacion = idEstadoReclamacion;
		}

		public String getTipoReclamacion() {
			return tipoReclamacion;
		}

		public void setTipoReclamacion(String tipoReclamacion) {
			this.tipoReclamacion = tipoReclamacion;
		}

		public String getMotivo() {
			return motivo;
		}

		public void setMotivo(String motivo) {
			this.motivo = motivo;
		}

	    

}
