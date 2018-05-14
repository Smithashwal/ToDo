package com.todo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.enom.NotificationType;
import com.todo.enom.RecordStatus;
import com.todo.exception.TransactionInfo;
import com.todo.model.UserAuthenticationToken;
import com.todo.model.Users;
import com.todo.repository.UserAuthenticationTokenRepository;
import com.todo.repository.UserRepository;

@Service
@Transactional
public class UserAuthenticationTokenServiceImpl implements UserAuthenticationTokenService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserAuthenticationTokenRepository tokenRepository;

	@Override
	public UserAuthenticationToken save(UserAuthenticationToken token) {

		Users user = token.getUser();

		user = userRepository.findByUserid(user.getUserid());
		token.setUser(user);

		TransactionInfo transactionInfo = new TransactionInfo();
		if (token.getExpiryDateTime().before(new Date())) {
			transactionInfo.generateToDoException("The token is expired", 500, NotificationType.ERROR);
		}

		return tokenRepository.save(token);
	}

	@Override
	public UserAuthenticationToken getByTokenId(long tokenid) {
		return tokenRepository.findByTokenId(tokenid);
	}

	@Override
	public UserAuthenticationToken getByToken(String token) {
		return tokenRepository.findByToken(token);
	}

	@Override
	public boolean isValidToken(String tokenString) {
		UserAuthenticationToken dbToken = getByToken(tokenString); // using the upper method

		if (null == dbToken) {
			return false;
		} else {
			if (dbToken.getExpiryDateTime().after(new Date()) && dbToken.getStatus().equals(RecordStatus.ACTIVE)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public UserAuthenticationToken getActiveTokenByUser(Users user) {
		List<UserAuthenticationToken> result= tokenRepository.findByUserAndExpiryDateTimeAfterAndStatus(user, new Date(), RecordStatus.ACTIVE);
		
		if(null==result || result.isEmpty()) {
			return null;
		}else {
			return result.get(0);
		}
		
	}

}
