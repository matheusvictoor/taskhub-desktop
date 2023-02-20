package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * @author Matheus Victor
 *
 */

public class ConnectionFactory {
	
	/*Driver de conexão do db com o Java */
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	/*Onde meu banco de dados está rodando: localização, porta e o nome do db*/
	public static final String URL = "jdbc:mysql://localhost:3306/taskhub";
	/* Usuário do db*/
	public static final String USER = "root";
	/* Senha de acesso ao db*/
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
	
	public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {		
		closeConnection(connection, statement);		
		try {
			
			if(resultSet != null) {
				resultSet.close();
			}
				
		} catch (Exception e) {
			throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", e);
		}		
	}
}
