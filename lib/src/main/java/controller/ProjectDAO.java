package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import model.Project;
import util.ConnectionFactory;

/**
 * 
 * @author Matheus Victor
 *
 */

public class ProjectDAO {
	public void save(Project project) {
		String sql = "INSERT INTO projects(name, description, createdAt, updatedAt) VALUES (?, ?, ? ,?)";
		
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			// Cria conexão com o banco de dados
			connection = ConnectionFactory.getConnection();
			// Cria uma preparação para executar a query
			statement = connection.prepareStatement(sql);
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, new Date(project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getUpdatedAt().getTime()));

			// Executa a SQL para inserir os dados
			statement.execute();

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao tentar salvar o projeto " + e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}

	public List<Project> getAll() {
		String sql = "SELECT * FROM projects";
		
		List<Project> projects = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement statement = null;

		// Classe que vai recuperar os dados do banco de dados
		ResultSet resultSet = null;

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			// Enquanto tiver dados no bando de dados, faça
			while (resultSet.next()) {
				Project project = new Project();
				
				project.setId(resultSet.getInt("id"));
				project.setName(resultSet.getString("name"));
				project.setDescription(resultSet.getString("description"));
				project.setCreatedAt(resultSet.getDate("createdAt"));
				project.setUpdatedAt(resultSet.getDate("updatedAt"));

				// Povoa um projeto com os dados recuperados
				projects.add(project);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar os projetos " + e.getMessage(), e);

		} finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}
		return projects;
	}

	public void update(Project project) {
		String sql = "UPDATE projects SET name = ?, description = ?, createdAt = ?, updatedAt = ? WHERE id = ?";
		
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			// Cria conexão com o banco de dados
			connection = ConnectionFactory.getConnection();
			// Cria uma preparação para executar a query
			statement = connection.prepareStatement(sql);

			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, new Date(project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
			statement.setInt(5, project.getId());

			// Executa a SQL para inserir os dados
			statement.execute();

		} catch (Exception e) {
			throw new RuntimeException("Erro ao tentar atualizar o projeto " + e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}

	public void delete(int id) {
		String sql = "DELETE FROM projects WHERE id = ?";
		
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);

			statement.setInt(1, id);

			statement.execute();

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao tentar excluir projeto " + e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}
}
