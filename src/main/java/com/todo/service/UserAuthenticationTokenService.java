package com.todo.service;

import java.util.Date;
import java.util.List;

import com.todo.model.UserAuthenticationToken;
import com.todo.model.Users;

public interface UserAuthenticationTokenService {

	public UserAuthenticationToken save(UserAuthenticationToken token);

	public UserAuthenticationToken getByToken(String token);

	public UserAuthenticationToken getByTokenId(long tokenid);
	
	public boolean isValidToken(String tokenString);
	
	public UserAuthenticationToken getActiveTokenByUser(Users user);

}
