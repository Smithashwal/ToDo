package com.todo.service;

import java.util.Date;
import java.util.Random;

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
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TransactionInfo transactionInfo;

	@Autowired
	UserAuthenticationTokenService userAuthenticationTokenService;

	@Override
	public String validateEmailPassword(String emailId, String password) {

		Users user = userRepository.findByEmail(emailId);
		if (null == user) {
			transactionInfo.generateToDoException("Invalid email Id", 500, NotificationType.ERROR);
		} else {
			if (user.getPassword().equals(password)) {

				UserAuthenticationToken generatedToken = userAuthenticationTokenService.getActiveTokenByUser(user);

				if (null == generatedToken) {
					UserAuthenticationToken tokenObj = new UserAuthenticationToken();
					tokenObj.setUser(user);
					tokenObj.setExpiryDateTime(new Date(2018, 4, 9));
					tokenObj.setStatus(RecordStatus.ACTIVE);
					tokenObj.setToken(generateUniqueToken());
					tokenObj = userAuthenticationTokenService.save(tokenObj);
					return tokenObj.getToken();
				} else {
					return generatedToken.getToken();
				}

			}
		}
		transactionInfo.generateToDoException("Invalid password", 500, NotificationType.ERROR);
		return null;
	}

	private String generateUniqueToken() {
		char[] a = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
				'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		char[] arr = new char[5];
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			int x = random.nextInt(a.length - 1);
			char c = a[x];
			arr[i] = c;
		}

		String newlyGeneratedToken = new String(arr);
		UserAuthenticationToken result = userAuthenticationTokenService.getByToken(newlyGeneratedToken);

		if (null == result) {
			return newlyGeneratedToken;
		} else {
			return generateUniqueToken();
		}

	}

}
