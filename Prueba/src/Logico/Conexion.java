package Logico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public static  Connection getConexion() {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;encrypt=false;databaseName=Proyecto;user=sa;password=123456";
	
		try {
        	Connection con = DriverManager.getConnection(connectionUrl); 
        	return con;
   
        }
        catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
	}
	
}
