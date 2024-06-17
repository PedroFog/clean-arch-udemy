package com.foganholi.cleanarch.core.usecase;

import com.foganholi.cleanarch.core.domain.Customer;

public interface FindCustomerByIdUseCase {
	
	Customer find(final String id);

}
