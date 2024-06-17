package com.foganholi.cleanarch.core.usecase;

import com.foganholi.cleanarch.core.domain.Customer;

public interface UpdateCustomerUseCase {
	
	void update(Customer customer, String zipCode);

}
