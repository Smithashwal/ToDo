package com.todo.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.enom.RecordStatus;
import com.todo.model.UserAuthenticationToken;
import com.todo.model.Users;

@Repository
public interface UserAuthenticationTokenRepository extends JpaRepository<UserAuthenticationToken, Serializable> {
	
	public UserAuthenticationToken findByTokenId(long id);
	
	public UserAuthenticationToken findByToken(String token);
	
	public List<UserAuthenticationToken> findByUserAndExpiryDateTimeAfterAndStatus(Users user, Date expiryDate, RecordStatus status);
	
	public List<UserAuthenticationToken> findBystatusAndExpiryDateTime(RecordStatus status, Date expiryDate);

}
