package com.todo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.model.Address;
import com.todo.model.Users;
import com.todo.repository.AddressRepository;
import com.todo.repository.UserRepository;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Override
	public Address save(Address	address) {
		Users user= address.getUser();
		
		user=userRepository.findByUserid(user.getUserid());
		address.setUser(user);
		
		return addressRepository.save(address);
	}

	@Override
	public Address findByAddressId(long addressid) {
		return addressRepository.findByAddressId(addressid);
	}

	

}
