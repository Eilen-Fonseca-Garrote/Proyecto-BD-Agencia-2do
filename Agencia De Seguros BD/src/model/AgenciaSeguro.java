package model;

public class AgenciaSeguro {
	private int idAgencia;
    private String nombreAgencia;
    private String direccionPostal;
    private String telefono;
    private String correoElectronico;
    private int idTipoSeguro;
    private String directorGeneral;
    private String jefeDepartamentoSeguros;
    private String jefeDepartamentoReclamaciones;
    

	public AgenciaSeguro(int idAgencia, String nombreAgencia,
			String direccionPostal, String telefono, String correoElectronico,
			int idTipoSeguro, String directorGeneral,
			String jefeDepartamentoSeguros, String jefeDepartamentoReclamaciones) {
		super();
		this.idAgencia = idAgencia;
		this.nombreAgencia = nombreAgencia;
		this.direccionPostal = direccionPostal;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.idTipoSeguro = idTipoSeguro;
		this.directorGeneral = directorGeneral;
		this.jefeDepartamentoSeguros = jefeDepartamentoSeguros;
		this.jefeDepartamentoReclamaciones = jefeDepartamentoReclamaciones;
	}
	public AgenciaSeguro() {
		// TODO Auto-generated constructor stub
	}
	public int getIdAgencia() {
		return idAgencia;
	}
	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}
	public String getNombreAgencia() {
		return nombreAgencia;
	}
	public void setNombreAgencia(String nombreAgencia) {
		this.nombreAgencia = nombreAgencia;
	}
	public String getDireccionPostal() {
		return direccionPostal;
	}
	public void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public int getIdTipoSeguro() {
		return idTipoSeguro;
	}
	public void setIdTipoSeguro(int idTipoSeguro) {
		this.idTipoSeguro = idTipoSeguro;
	}
	public String getDirectorGeneral() {
		return directorGeneral;
	}
	public void setDirectorGeneral(String directorGeneral) {
		this.directorGeneral = directorGeneral;
	}
	public String getJefeDepartamentoSeguros() {
		return jefeDepartamentoSeguros;
	}
	public void setJefeDepartamentoSeguros(String jefeDepartamentoSeguros) {
		this.jefeDepartamentoSeguros = jefeDepartamentoSeguros;
	}
	public String getJefeDepartamentoReclamaciones() {
		return jefeDepartamentoReclamaciones;
	}
	public void setJefeDepartamentoReclamaciones(
			String jefeDepartamentoReclamaciones) {
		this.jefeDepartamentoReclamaciones = jefeDepartamentoReclamaciones;
	}

    

}
