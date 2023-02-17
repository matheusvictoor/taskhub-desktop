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
	private Date cratedAt;
	private Date updateAt;
	
	public Task(String name, String description, byte status, List<Tag> tags, String notes, Date deadline, boolean completed, Date cratedAt, Date updateAt) {
		this.name = name;
		this.description = description;
		this.status = status;
		this.tags = tags;
		this.notes = notes;
		this.deadline = deadline;
		this.completed = completed;
		this.cratedAt = cratedAt;
		this.updateAt = updateAt;
	}
	
	public Task () {
		this.completed = false;
		this.cratedAt = new Date();
		this.updateAt = new Date();	
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

	public Date getCratedAt() {
		return cratedAt;
	}

	public void setCratedAt(Date cratedAt) {
		this.cratedAt = cratedAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
}
