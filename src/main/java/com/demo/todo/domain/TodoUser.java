package com.demo.todo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class TodoUser implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	@Column
	private String userName;
	@Column
	private String email;
	@Column(nullable = true)
	private String address;
	@JsonIgnore
	@NonNull
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<UserTask> userTasks = new HashSet<UserTask>(0);

	public TodoUser(String userName, String email, String address) {
		super();
		this.userName = userName;
		this.email = email;
		this.address = address;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
