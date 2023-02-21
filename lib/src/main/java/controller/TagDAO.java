package controller;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import model.Tag;
import util.ConnectionFactory;

/**
 * 
 * @author Matheus Victor
 *
 */

public class TagDAO {
	public void save(Tag tag) {
		String sql = "INSERT INTO tags(name, color, createdAt, updatedAt) VALUES(?, ?, ?, ?)";
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			// Cria a conexão com o banco de dados
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, tag.getName());
			statement.setString(2, tag.getColor());
			statement.setDate(3, new Date(tag.getCreatedAt().getTime()));
			statement.setDate(4, new Date(tag.getUpdatedAt().getTime()));
			
			statement.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao salvar a tag", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}
	
	public List<Tag> getAll(){
		String sql = "SELECT * FROM tags";
		
		List<Tag> tags = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		ResultSet resultSet = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Tag tag = new Tag();
				
				tag.setId(resultSet.getInt("id"));
				tag.setName(resultSet.getString("name"));
				tag.setColor(resultSet.getString("color"));
				tag.setCreatedAt(resultSet.getDate("createdAt"));
				tag.setUpdatedAt(resultSet.getDate("updatedAt"));
				
				tags.add(tag);
			}		
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar as tags", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}		
		return tags;
	}
	
	public void update(Tag tag) {
		String sql = "UPDATE tags SET name = ?, color = ?, createdAt = ?, updatedAt =? WHERE id = ?";
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, tag.getName());
			statement.setString(2, tag.getColor());
			statement.setDate(3, new Date(tag.getCreatedAt().getTime()));
			statement.setDate(4, new Date(tag.getUpdatedAt().getTime()));
			statement.setInt(5, tag.getId());
			
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao atualizar a tag", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}

	public void delete(int id) {
		String sql = "DELETE FROM tags WHERE id = ?";
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			statement.execute();
			
		} catch (Exception e) {
			throw new RuntimeException("Erro ao deletar a tag", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}		
	}
}
