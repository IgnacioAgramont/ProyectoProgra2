package Clases;

public class Proveedores {
	
	private int idProveedor;
	private String Empresa;
	private String Direccion;
	private int Celular;
	
	public int getIdProveedor() {
		return idProveedor;
	}
	public String getEmpresa() {
		return Empresa;
	}
	public String getDireccion() {
		return Direccion;
	}
	public int getCelular() {
		return Celular;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public void setCelular(int celular) {
		Celular = celular;
	}
	
	
}
