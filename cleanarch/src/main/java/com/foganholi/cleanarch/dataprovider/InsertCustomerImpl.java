package com.foganholi.cleanarch.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.foganholi.cleanarch.core.dataprovider.InsertCustomer;
import com.foganholi.cleanarch.core.domain.Customer;
import com.foganholi.cleanarch.dataprovider.repository.CustomerRepository;
import com.foganholi.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;

@Component
public class InsertCustomerImpl implements InsertCustomer {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerEntityMapper customerEntityMapper;

	@Override
	public void insert(Customer customer) {
		customerRepository.save(customerEntityMapper.toCustomerEntity(customer));
	}

}
