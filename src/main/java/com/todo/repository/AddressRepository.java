package com.todo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Serializable> {

	public Address findByAddressId(long id);
	
	public List<Address> findByPincode(long pincode);
	
	public List<Address> findByStreetNameAndCity(String streetName, String city);
	
}
