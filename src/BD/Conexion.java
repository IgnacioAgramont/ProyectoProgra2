package BD;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;

public class Conexion {
	private String usuario = "root";
	private String pass = "";
	private String host = "localhost";
	private String nombreBDD = "MarcaMercadeo";
	private Connection con = null;
	public Connection getConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String servidor = "jdbc:mysql://"+host+"/"+nombreBDD;
			con = (Connection) DriverManager.getConnection(servidor, usuario, pass);
			return con;
			
			
		}catch (Exception e) {
			e.printStackTrace();
			return con;
		}
	}
}