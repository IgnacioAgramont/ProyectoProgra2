package Clases;

public class Empresa {
	private String Nombre;
	private String Direccion;
	private int Telefono;
	public Empresa(String Nombre, String Direccion, int Telefono) {
		this.Nombre = Nombre;
		this.Direccion = Direccion;
		this.Telefono = Telefono;
	}
	public String getNombre() {
		return Nombre;
	}
	public String getDireccion() {
		return Direccion;
	}
	public int getTelefono() {
		return Telefono;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
	
}
