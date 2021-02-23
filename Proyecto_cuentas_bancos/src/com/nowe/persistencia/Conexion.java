package com.nowe.persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	  protected Connection miConexion;
	    
	    public void abrirConexion() throws ClassNotFoundException, SQLException  {
	        System.out.println("Abrir conexion");
	        //Cargar el driver
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        System.out.println("Abrir conexion despues class");
	        //Definicion del String de conexion
	        String stringConexion =  "jdbc:sqlserver://localhost:1433;" +
	                       "databaseName=CUENTAS_BANCOS;" +
	                       "user=miguel;" +
	                        "password=miguel1976;" +
	                      "encrypt=false;" +
	                     "trustServerCertificate=false;" +
	                      "loginTimeout=30;";
	        //Obtener un objeto de tipo conexion
	        miConexion = DriverManager.getConnection(stringConexion);
	        System.out.println("Exito al abrir la conexion");
	        
	    }
	    
	    public void cerrarConexion() throws SQLException {
	        miConexion.close();
	    }

}
