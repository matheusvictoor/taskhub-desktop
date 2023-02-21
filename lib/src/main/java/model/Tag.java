package model;

import java.util.Date;
import java.util.logging.Logger;

/**
 * 
 * @author Matheus Victor
 *
 */

public class Tag {
	
	private static final Logger LOG = Logger.getLogger(Tag.class.getName());
	private int id;
	private String name;
	private String color;
	private Date createdAt;
	private Date updatedAt;
	
	public Tag (String name, String color) {
		this.name = name;
		this.color = color;
	}
	
	public Tag () {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return this.name;
	}	
}
