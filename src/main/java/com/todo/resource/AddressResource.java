package com.todo.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.todo.model.Address;
import com.todo.service.AddressService;

@Path("/Address")
public class AddressResource {
	
	@Autowired
    AddressService addressService;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Address getAddressId(@PathParam("id") long addressId) {
		return addressService.findByAddressId(addressId);
	}

}
