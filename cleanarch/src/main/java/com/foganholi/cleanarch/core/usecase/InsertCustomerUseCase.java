package com.foganholi.cleanarch.core.usecase;

import com.foganholi.cleanarch.core.domain.Customer;

public interface InsertCustomerUseCase {
	
	void insert(Customer customer, String zipCode);

}
