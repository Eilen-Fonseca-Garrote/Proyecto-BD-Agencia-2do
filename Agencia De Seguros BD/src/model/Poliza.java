package model;

import java.sql.Date;

public class Poliza {
	private int numPoliza;
	private Date fechaInicio;
	private Date fechaFin;
	private double primaMensual;
	private double montoTotal;
	private int idAgencia; // Clave foránea a AgenciaSeguro
	private String id; // Clave foránea a Cliente
	private int idEstadoPoliza; // Clave foránea a EstadoPoliza
	private int idCobertura;

	public Poliza(int numPoliza, Date fechaInicio, Date fechaFin,
			double primaMensual, double montoTotal, int idAgencia, String id,
			int idEstadoPoliza, int idCobertura) {
		super();
		this.numPoliza = numPoliza;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.primaMensual = primaMensual;
		this.montoTotal = montoTotal;
		this.idAgencia = idAgencia;
		this.id = id;
		this.idEstadoPoliza = idEstadoPoliza;
		this.setIdCobertura(idCobertura);
	}

	public Poliza() {
		// TODO Auto-generated constructor stub
	}

	public int getNumPoliza() {
		return numPoliza;
	}

	public void setNumPoliza(int numPoliza) {
		this.numPoliza = numPoliza;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public double getPrimaMensual() {
		return primaMensual;
	}

	public void setPrimaMensual(double primaMensual) {
		this.primaMensual = primaMensual;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public int getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIdEstadoPoliza() {
		return idEstadoPoliza;
	}

	public void setIdEstadoPoliza(int idEstadoPoliza) {
		this.idEstadoPoliza = idEstadoPoliza;
	}

	public int getIdCobertura() {
		return idCobertura;
	}

	public void setIdCobertura(int idCobertura) {
		this.idCobertura = idCobertura;
	}

}
