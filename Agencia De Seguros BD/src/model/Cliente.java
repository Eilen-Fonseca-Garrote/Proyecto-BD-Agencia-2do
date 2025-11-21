package model;

public class Cliente {
	private String id;
	private char sexo;
	private String nombre;
	private String apellidos;
	private int edad;
	private String direccionPostal;
	private String telefono;
	private String correoElectronico;
	private String pais;

	public Cliente(String id, char sexo, String nombre, String apellidos,
			int edad, String direccionPostal, String telefono,
			String correoElectronico, String pais) {
		super();
		this.id = id;
		this.sexo = sexo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.direccionPostal = direccionPostal;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.pais = pais;
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
