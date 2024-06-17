package com.foganholi.cleanarch.core.dataprovider;

import java.util.Optional;

import com.foganholi.cleanarch.core.domain.Customer;

public interface FindCustomerById {
	
	Optional<Customer> find(final String id);

}
