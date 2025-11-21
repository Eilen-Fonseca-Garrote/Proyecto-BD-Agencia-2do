package model;

public class Seguro {
	 private int idTipoSeguro;
	    private String tipo;
	    
	    
		public Seguro(int idTipoSeguro, String tipo) {
			super();
			this.idTipoSeguro = idTipoSeguro;
			this.tipo = tipo;
		}


		public Seguro() {
			// TODO Auto-generated constructor stub
		}


		public int getIdTipoSeguro() {
			return idTipoSeguro;
		}


		public void setIdTipoSeguro(int idTipoSeguro) {
			this.idTipoSeguro = idTipoSeguro;
		}


		public String getTipo() {
			return tipo;
		}


		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		
		


}
