package com.todo.service;

import com.todo.model.Address;

public interface AddressService {

	public Address save(Address address);
	
	public Address findByAddressId(long addressid);
}
