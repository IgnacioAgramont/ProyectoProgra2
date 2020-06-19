package Clases;

public class Usuario {
	private int idUsuario;
	private String Usuario;
	private String Password;
	private String Nombre;
	private String Correo;
	private int Celular;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public String getUsuario() {
		return Usuario;
	}
	public String getPassword() {
		return Password;
	}
	public String getNombre() {
		return Nombre;
	}
	public String getCorreo() {
		return Correo;
	}
	public int getCelular() {
		return Celular;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public void setCelular(int celular) {
		Celular = celular;
	}
	
}
