package Clases;

public class Producto {
	
	private String CodProd;
	private String Nombre;
	private int UnidPaq;
	private double PrecioPaq;
	private int PaqStock;
	private boolean Disponibilidad;
	private int Categoria;
	private int Proveedor;
	
	public String getNombre() {
		return Nombre;
	}
	public int getCategoria() {
		return Categoria;
	}
	public String getCodProd() {
		return CodProd;
	}
	public int getUnidPaq() {
		return UnidPaq;
	}
	public double getPrecioPaq() {
		return PrecioPaq;
	}
	public int getPaqStock() {
		return PaqStock;
	}
	public boolean isDisponibilidad() {
		return Disponibilidad;
	}
	public int getProveedor() {
		return Proveedor;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public void setCategoria(int categoria) {
		Categoria = categoria;
	}
	public void setCodProd(String codProd) {
		CodProd = codProd;
	}
	public void setUnidPaq(int unidPaq) {
		UnidPaq = unidPaq;
	}
	public void setPrecioPaq(double precioPaq) {
		PrecioPaq = precioPaq;
	}
	public void setPaqStock(int paqStock) {
		PaqStock = paqStock;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		Disponibilidad = disponibilidad;
	}
	public void setProveedor(int proveedor) {
		Proveedor = proveedor;
	}
	
	
}
