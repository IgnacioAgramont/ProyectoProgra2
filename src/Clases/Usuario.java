package Clases;

public class Usuario {
	private int idUsuario;
	private String Password;
	private String Nombre;
	private int Celular;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public String getPassword() {
		return Password;
	}
	public String getNombre() {
		return Nombre;
	}
	public int getCelular() {
		return Celular;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public void setCelular(int celular) {
		Celular = celular;
	}
	
}
