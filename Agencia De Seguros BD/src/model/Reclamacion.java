package model;

import java.sql.Date;

public class Reclamacion {
	private int numeroReclamacion;
    private Date fechaSiniestro;
    private double montoReclamado;
    private double montoIndemnizado;
    private int numPoliza; // Clave foránea a Poliza
    private int idEstadoReclamacion; // Clave foránea a EstadoReclamacion
    private int idSiniestro; // Clave foránea a Siniestro
    
    
	public Reclamacion(int numeroReclamacion, Date fechaSiniestro,
			double montoReclamado, double montoIndemnizado, int numPoliza,
			int idEstadoReclamacion, int idSiniestro) {
		super();
		this.numeroReclamacion = numeroReclamacion;
		this.fechaSiniestro = fechaSiniestro;
		this.montoReclamado = montoReclamado;
		this.montoIndemnizado = montoIndemnizado;
		this.numPoliza = numPoliza;
		this.idEstadoReclamacion = idEstadoReclamacion;
		this.idSiniestro = idSiniestro;
	}


	public Reclamacion() {
		// TODO Auto-generated constructor stub
	}


	public int getNumeroReclamacion() {
		return numeroReclamacion;
	}


	public void setNumeroReclamacion(int numeroReclamacion) {
		this.numeroReclamacion = numeroReclamacion;
	}


	public Date getFechaSiniestro() {
		return fechaSiniestro;
	}


	public void setFechaSiniestro(Date fechaSiniestro) {
		this.fechaSiniestro = fechaSiniestro;
	}


	public double getMontoReclamado() {
		return montoReclamado;
	}


	public void setMontoReclamado(double montoReclamado) {
		this.montoReclamado = montoReclamado;
	}


	public double getMontoIndemnizado() {
		return montoIndemnizado;
	}


	public void setMontoIndemnizado(double montoIndemnizado) {
		this.montoIndemnizado = montoIndemnizado;
	}


	public int getNumPoliza() {
		return numPoliza;
	}


	public void setNumPoliza(int numPoliza) {
		this.numPoliza = numPoliza;
	}


	public int getIdEstadoReclamacion() {
		return idEstadoReclamacion;
	}


	public void setIdEstadoReclamacion(int idEstadoReclamacion) {
		this.idEstadoReclamacion = idEstadoReclamacion;
	}


	public int getIdSiniestro() {
		return idSiniestro;
	}


	public void setIdSiniestro(int idSiniestro) {
		this.idSiniestro = idSiniestro;
	}
	
	


}
