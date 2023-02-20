package model;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * 
 * @author Matheus Victor
 *
 */

public class Task {
	
	private static final Logger LOG = Logger.getLogger(Task.class.getName());
	private int id;
	private int idProject;
	private String name;
	private String description;
	private byte status;
	private List<Tag> tags;
	private String notes;
	private Date deadline;
	private boolean completed;
	private Date createdAt;
	private Date updatedAt;
	
	public Task(String name, String description, byte status, List<Tag> tags, String notes, Date deadline, boolean completed, Date createdAt, Date updatedAt) {
		this.name = name;
		this.description = description;
		this.status = status;
		this.tags = tags;
		this.notes = notes;
		this.deadline = deadline;
		this.completed = completed;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public Task () {
		this.completed = false;
		this.createdAt = new Date();
		this.updatedAt = new Date();	
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
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
