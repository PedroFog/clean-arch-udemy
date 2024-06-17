package com.foganholi.cleanarch.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.foganholi.cleanarch.core.dataprovider.DeleteCustomerById;
import com.foganholi.cleanarch.dataprovider.repository.CustomerRepository;

@Component
public class DeleteCustomerByIdImpl implements DeleteCustomerById {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void delete(String id) {
		customerRepository.deleteById(id);
	}

}
