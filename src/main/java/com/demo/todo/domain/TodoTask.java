package com.demo.todo.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class TodoTask implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	@Column
	private String taskName;
	@Column
	private String description;
	@Column
	protected LocalDateTime createdDate;
	@Column
	protected LocalDateTime updatedDate;
	@JsonIgnore
	@NonNull
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "task")
	private Set<UserTask> userTasks = new HashSet<UserTask>(
			0);

	public TodoTask(String taskName, String description, LocalDateTime createdDate, LocalDateTime updatedDate,
			Set<UserTask> userTasks) {
		super();
		this.taskName = taskName;
		this.description = description;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.userTasks = userTasks;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the createdDate
	 */
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedDate
	 */
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the userTasks
	 */
	public Set<UserTask> getUserTasks() {
		return userTasks;
	}

	/**
	 * @param userTasks the userTasks to set
	 */
	public void setUserTasks(Set<UserTask> userTasks) {
		this.userTasks = userTasks;
	}

	


}
