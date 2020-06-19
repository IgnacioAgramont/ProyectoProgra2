package BD;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import Clases.Usuario;

public class SqlUsuarios extends Conexion {
	
	public boolean login(Usuario usr) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		
		String sql = "select * from Usuario where Usuario = ?";
		
		
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, usr.getUsuario());
			rs = (ResultSet) ps.executeQuery();
			
			if(rs.next()) {
				if(usr.getPassword().equals(rs.getString(3))){
					usr.setIdUsuario(rs.getInt(1));
					usr.setNombre(rs.getString(4));
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
		String sql = "insert into Usuario  (Usuario, Password, Nombre, Correo, Celular) values (?,?,?,?,?)";

		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, usr.getUsuario());
			ps.setString(2, usr.getPassword());
			ps.setString(3, usr.getNombre());
			ps.setString(4, usr.getCorreo());
			ps.setInt(5, usr.getCelular());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
