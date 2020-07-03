package Clases;

public class Cliente {
	private int cod;
	private String Nombre;
	private String Direccion;
	private int Celular;
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNombre() {
		return Nombre;
	}
	public String getDireccion() {
		return Direccion;
	}
	public int getCelular() {
		return Celular;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public void setCelular(int celular) {
		Celular = celular;
	}
	
	
}
