package BD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import Clases.Cliente;
import Clases.Producto;
import Clases.Proveedores;
import Clases.Usuario;
import Clases.Ventas;


public class SqlUsuarios extends Conexion {

	public boolean login(Usuario usr) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		
		String sql = "select * from Empleado where idEmpleado = ?";
		
		
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, usr.getIdUsuario());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(usr.getPassword().equals(rs.getString(2))){
					usr.setIdUsuario(rs.getInt(1));
					usr.setNombre(rs.getString(3));
					JOptionPane.showMessageDialog(null, "Bienvenido "+usr.getNombre());
					return true;
				}else {
					return false;
				}
			}
			return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

	public boolean registrar(Usuario usr) {

		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "insert into Empleado values (?,?,?,?)";

		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, usr.getIdUsuario());
			ps.setString(2, usr.getPassword());
			ps.setString(3, usr.getNombre());
			ps.setInt(4, usr.getCelular());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean RegProv(Proveedores prov) {

		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "insert into Proveedor (Empresa, Direccion, Celular) values (?,?,?)";
		
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, prov.getEmpresa());
			ps.setString(2, prov.getDireccion());
			ps.setInt(3, prov.getCelular());
			ps.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public String BuscarProv(Proveedores prov) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		ResultSet rs = null;
		
		String sql = "select * from Proveedor where idProveedor = ? or Empresa = ?";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, prov.getIdProveedor());
			ps.setString(2, prov.getEmpresa());
			rs = ps.executeQuery();
			while(rs.next()) {
				String cad = rs.getInt(1)+";"+rs.getString(2)+";"+rs.getString(3)+";"+rs.getInt(4);
				return cad;
			}
			
			return "";
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "El cliente con numero de celular "+cli.getCelular()+" no está registrado o no se encuentra, verifique");
			e.printStackTrace();
			return "";
		}
	}
	
	public boolean UpdateProv(Proveedores prov) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "update Proveedor set Empresa = ? , Direccion = ? , Celular = ? where idProveedor = ?";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, prov.getEmpresa());
			ps.setString(2, prov.getDireccion());
			ps.setInt(3, prov.getCelular());
			ps.setInt(4, prov.getIdProveedor());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean RegCli(Cliente cli) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "insert into Cliente (Nombre, Direccion, Celular) values (?,?,?)";
		
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, cli.getNombre());
			ps.setString(2, cli.getDireccion());
			ps.setInt(3, cli.getCelular());
			ps.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String BuscarCli(Cliente cli) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		ResultSet rs = null;
		
		String sql = "select * from Cliente where Celular = ? or Nombre = ?";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, cli.getCelular());
			ps.setString(2, cli.getNombre());
			rs = ps.executeQuery();
			while(rs.next()) {
				String cad = rs.getInt(1)+";"+rs.getString(2)+";"+rs.getString(3)+";"+rs.getInt(4);
				return cad;
			}
			return "";
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}
	public boolean UpdateCli(Cliente cli) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "update Cliente set Nombre = ? , Direccion = ? , Celular = ? where idCliente = ?";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, cli.getNombre());
			ps.setString(2, cli.getDireccion());
			ps.setInt(3, cli.getCelular());
			ps.setInt(4, cli.getCod());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	//Para llenar el combo box de ProdAdd
	public static ArrayList<String> llenar_cat(){
		
		ArrayList<String> lista = new ArrayList<String>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		
		String sql = "select * from Categoria";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				lista.add(rs.getString("Nombre"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public static ArrayList<String> llenar_cli(){
		
		ArrayList<String> lista = new ArrayList<String>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		
		String sql = "select * from Cliente";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				lista.add(rs.getString("Nombre"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	public static ArrayList<String> llenar_prov(){
		
		ArrayList<String> lista = new ArrayList<String>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		
		String sql = "select * from Proveedor";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				lista.add(rs.getString("Empresa"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public static ArrayList<String> llenar_prod(){
		
		ArrayList<String> lista = new ArrayList<String>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		
		String sql = "select * from Producto";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				lista.add(rs.getString("Producto"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public boolean AgregarCat(String cat) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "insert into Categoria (Nombre) values (?)";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, cat);
			ps.execute();
			return true;
		}catch (SQLException e) {
			return false;
		}
	}
	
	public boolean RegProd(Producto prod) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "insert into Producto values (?,?,?,?,?,?,?,?)";
		
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, prod.getCodProd());
			ps.setString(2, prod.getNombre());
			ps.setInt(3, prod.getUnidPaq());
			ps.setDouble(4, prod.getPrecioPaq());
			ps.setInt(5, prod.getPaqStock());
			if(prod.isDisponibilidad()) {
				ps.setInt(6, 1);
			}else {
				ps.setInt(6, 0);
			}
			ps.setInt(7, prod.getCategoria());
			ps.setInt(8, prod.getProveedor());
			ps.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String BuscarProd(Producto prod) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		ResultSet rs = null;
		String sql = "select * from Producto where idProducto = ? or idCategoria = ? or Producto = ?";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, prod.getCodProd());
			ps.setInt(2, prod.getCategoria());
			ps.setString(3, prod.getNombre());
			rs = ps.executeQuery();
			while(rs.next()) {
				
				String cad = rs.getString(1)+";"+rs.getString(2)+";"+rs.getInt(3)+";"+rs.getDouble(4)+";"+rs.getInt(5)+";"+rs.getInt(6);
				return cad;
			}
			
			return "";
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public boolean UpdateProd(Producto prod) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "update Producto set Producto = ? , Unidades = ? , Precio = ? , Paquetes = ?  where idProducto = ?";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, prod.getNombre());
			ps.setInt(2, prod.getUnidPaq());
			ps.setDouble(3, prod.getPrecioPaq());
			ps.setInt(4, prod.getPaqStock());
			ps.setString(5, prod.getCodProd());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean Venta(Ventas venta) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "insert into Ventas (idEmpleado, idProducto, Cantidad, idCliente) values (?,?,?,?)";
		
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, venta.getIdEmpleado());
			ps.setString(2, venta.getIdProducto());
			ps.setInt(3, venta.getCantidad());
			ps.setInt(4, venta.getIdCliente());
			ps.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}	
	public int getproveedor(String prov) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		
		String sql = "select * from Proveedor where Empresa = ?";
		
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, prov);
			rs = ps.executeQuery();
			if(rs.next()) {
				int valor = rs.getInt(1);
				return valor;
			}else {
				return -1;
			}
			}catch(Exception e) {
				e.printStackTrace();
				return -1;
			}
	}
	public int getcliente(String cli) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		
		String sql = "select * from Cliente where Nombre = ?";
		
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, cli);
			rs = ps.executeQuery();
			if(rs.next()) {
				int valor = rs.getInt(1);
				return valor;
			}else {
				return -1;
			}
			}catch(Exception e) {
				e.printStackTrace();
				return -1;
			}
	}
	public String getproducto2(String prod) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		
		String sql = "select * from Producto where Producto = ?";
		
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, prod);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}else {
				return "";
			}
			}catch(Exception e) {
				e.printStackTrace();
				return "";
			}
	}
	public int getproducto(String prod) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		
		String sql = "select * from Producto where Producto = ?";
		
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, prod);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(7);
			}else {
				return -1;
			}
			}catch(Exception e) {
				e.printStackTrace();
				return -1;
			}
	}
	public int getcategoria(String cat) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		
		String sql = "select idCategoria from Categoria where Nombre = ?";
		
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, cat);
			rs = ps.executeQuery();
			if(rs.next()) {
				int valor = rs.getInt(1);
				return valor;
			}else {
				return -1;
			}
			}catch(Exception e) {
				e.printStackTrace();
				return -1;
			}
	}
	
	
	public boolean ConsultaPass(Usuario usr) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		
		String sql = "select idEmpleado from Empleado where idEmpleado = ?";
		
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, usr.getIdUsuario());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(usr.getPassword().equals(rs.getString(2))){
					usr.setIdUsuario(rs.getInt(1));
					usr.setNombre(rs.getString(3));
					return true;
				}else {
					return false;
				}
			}
			return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean UpdatePass(Usuario usr) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "update Empleado set Contraseña = ? where idEmpleado = ?";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, usr.getPassword());
			ps.setInt(2, usr.getIdUsuario());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
}
