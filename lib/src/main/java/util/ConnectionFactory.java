package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 
 * @author Matheus Victor
 *
 */

public class ConnectionFactory {
	
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/dbtaskhub";
	public static final String USER = "root";
	public static final String PASS = "";
	
	public static java.sql.Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			throw new RuntimeException("Erro na concexão com o banco de dados", e);
		}
	}
	
	public static void closeConnection(Connection connection) {
		try {
			// caso tenha alguma conexão aberta com o db, feche
			if(connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", e);
		}		
	}
	
	public static void closeConnection(Connection connection, PreparedStatement statement) {		
		closeConnection(connection);		
		try {
			
			if(statement != null) {
				statement.close();
			}
				
		} catch (Exception e) {
			throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", e);
		}		
	}
}
