package com.todo.model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.todo.enom.RecordStatus;

@Entity(name="todo")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ToDo {

	@Id
	@GeneratedValue
	private long toDoId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="remindDateTime")
	private Date remindDateTime;

	@Column(name="status")
	private RecordStatus status;
	
	@Column(name="createdDateTime")
	private Date createdDateTime = new Date();

	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinColumn(referencedColumnName="userid",name="userid")
	
	Users user;
	
	public long getToDoId() {
		return toDoId;
	}

	public void setToDoId(long toDoId) {
		this.toDoId = toDoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRemindDateTime() {
		return remindDateTime;
	}

	public void setRemindDateTime(Date remindDateTime) {
		this.remindDateTime = remindDateTime;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	
	public RecordStatus getStatus() {
		return status;
	}

	public void setStatus(RecordStatus status) {
		this.status = status;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	

}

