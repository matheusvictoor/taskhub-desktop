package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Task;
import util.ConnectionFactory;

public class TaskDAO {	
	public void save(Task task) {
		String sql = "INSERT INTO tasks(idProject, name, description, status, notes, deadline, completed, createdAt, updatedAt) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";		
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			// Cria uma conexão com o banco de dados
			connection = ConnectionFactory.getConnection();
			// Cria uma preparação para executar a query
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, task.getIdProject());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setByte(4, task.getStatus());
			statement.setString(5, task.getNotes());
			statement.setDate(6, new Date(task.getDeadline().getTime()));
			statement.setBoolean(7, task.isCompleted());
			statement.setDate(8, new Date(task.getCreatedAt().getTime()));
			statement.setDate(9, new Date(task.getUpdatedAt().getTime()));
			statement.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao salvar a tarefa " + e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}
	
	public List<Task> getAll() {
		String sql = "SELECT * FROM tasks";	
		
		List<Task> tasks = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		ResultSet resultSet = null;
		
		try {
			// Cria uma conexão com o banco de dados
			connection = ConnectionFactory.getConnection();
			// Cria uma preparação para executar a query
			statement = connection.prepareStatement(sql);
			
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Task task = new Task();
				
				task.setId(resultSet.getInt("id"));
				task.setIdProject(resultSet.getInt("idProject"));
				task.setName(resultSet.getString("name"));
				task.setDescription(resultSet.getString("description"));
				task.setStatus(resultSet.getByte("status"));
				task.setNotes(resultSet.getString("notes"));
				task.setDeadline(resultSet.getDate("deadline"));
				task.setCompleted(resultSet.getBoolean("completed"));
				task.setCreatedAt(resultSet.getDate("createdAt"));	
				task.setUpdatedAt(resultSet.getDate("updatedAt"));
				
				// Adiciona os dados recuperador a uma tarefa
				tasks.add(task);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar as tarefas " + e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}
		
		return tasks;
	}
	
	public List<Task> getByProjectId(int id){
		String sql = "SELECT * FROM tasks WHERE idProject = ?";
		
		List<Task> tasks = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		ResultSet resultSet = null;
		
		try {
			
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Task task = new Task();
				
				task.setId(resultSet.getInt("id"));
				task.setIdProject(resultSet.getInt("idProject"));
				task.setName(resultSet.getString("name"));
				task.setDescription(resultSet.getString("description"));
				task.setStatus(resultSet.getByte("status"));
				task.setNotes(resultSet.getString("notes"));
				task.setDeadline(resultSet.getDate("deadline"));
				task.setCompleted(resultSet.getBoolean("completed"));
				task.setCreatedAt(resultSet.getDate("createdAt"));	
				task.setUpdatedAt(resultSet.getDate("updatedAt"));
				
				tasks.add(task);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar as tarefas " + e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}
		
		return tasks;
	}
	
	public void update(Task task) {
		String sql = "UPDATE tasks SET idProject = ?, name = ?, description = ?, status = ?, notes = ?, deadline = ?, completed = ?, createdAt = ?, updatedAt = ? WHERE id = ?";
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			// Cria uma conexão com o banco de dados
			connection = ConnectionFactory.getConnection();
			// Cria uma preparação para executar a query
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, task.getIdProject());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setByte(4, task.getStatus());
			statement.setString(5, task.getNotes());
			statement.setDate(6, new Date(task.getDeadline().getTime()));
			statement.setBoolean(7, task.isCompleted());
			statement.setDate(8, new Date(task.getCreatedAt().getTime()));
			statement.setDate(9, new Date(task.getUpdatedAt().getTime()));
			statement.setInt(10, task.getId());
			
			statement.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao atualizar a tarefa " + e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM tasks WHERE id = ?";		
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			statement.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao deletar a tarefa " + e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}
}
