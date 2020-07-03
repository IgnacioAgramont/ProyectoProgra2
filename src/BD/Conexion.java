package BD;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;

public class Conexion {
	private static String usuario = "root";
	private static String pass = "";
	private static String host = "127.0.0.1";
	//127.0.0.1
	private static String nombreBDD = "proy";
	private static Connection con = null;
	public static Connection getConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String servidor = "jdbc:mysql://"+host+"/"+nombreBDD+"?autoReconnect=true&useSSL=false";
			con = (Connection) DriverManager.getConnection(servidor, usuario, pass);
			return con;
			
			
		}catch (Exception e) {
			e.printStackTrace();
			return con;
		}
	}
}