package pe.edu.tecsup.app.entities;

public class Cliente {

	private int codigo;
	private String nombres;
	private String paterno;
	private String materno;

	public String getNombreCompleto() {
		return this.nombres + " " + this.paterno + " " + this.materno;
	}

	
}