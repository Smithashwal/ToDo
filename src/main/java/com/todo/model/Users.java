package com.todo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.todo.enom.RecordStatus;

@Entity(name="users")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Users {

    @Id
    @GeneratedValue
    private long userid;

    @Column(name="username")
    private String username;
    
    @Column(name="email")
    private String email;
    
    @Column(name="password")
	private String password;
    
    @Column(name="role")
	private String role;
    
    @Column(name="status")
	private RecordStatus status;
    
    @Column(name="createdDateTime")
	private Date createdDateTime;
   
    @Column
    @OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    @JsonIgnore
    List<ToDo> todo;
    
    @Column
    @OneToMany(fetch=FetchType.LAZY,mappedBy="user")
    @JsonIgnore
    List<Address> address;

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public RecordStatus getStatus() {
		return status;
	}

	public void setStatus(RecordStatus status) {
		this.status = status;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public List<ToDo> getTodo() {
		return todo;
	}

	public void setTodo(List<ToDo> todo) {
		this.todo = todo;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
    
    
}