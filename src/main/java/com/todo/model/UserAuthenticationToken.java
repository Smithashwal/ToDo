package com.todo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.todo.enom.RecordStatus;

@Entity(name = "token")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserAuthenticationToken {

	@Id
	@GeneratedValue
	private long tokenId;

	@Column(name = "token", unique=true)
	private String token;
	
	@Column(name = "status")
	private RecordStatus status= RecordStatus.ACTIVE;
	
	@Column(name = "createdDateTime")
	private Date createdDateTime = new Date();
	
	@Column(name = "ExpiryDateTime")
	private Date expiryDateTime;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinColumn(referencedColumnName="userid",name="userid")
	Users user;

	public long getTokenId() {
		return tokenId;
	}

	public void setTokenId(long tokenId) {
		this.tokenId = tokenId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public Date getExpiryDateTime() {
		return expiryDateTime;
	}

	public void setExpiryDateTime(Date expiryDateTime) {
		this.expiryDateTime = expiryDateTime;
	}

	public UserAuthenticationToken() {

	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	
	
}
