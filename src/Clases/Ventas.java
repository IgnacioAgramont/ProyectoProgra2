package Clases;

public class Ventas {
	private int idVentas;
	private int idEmpleado;
	private String idProducto;
	private int idCliente;
	private int Cantidad;
	
	public int getIdVentas() {
		return idVentas;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setIdVentas(int idVentas) {
		this.idVentas = idVentas;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
}
