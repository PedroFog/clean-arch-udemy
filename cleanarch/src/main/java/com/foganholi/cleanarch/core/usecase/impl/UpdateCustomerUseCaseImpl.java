package com.foganholi.cleanarch.core.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.foganholi.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.foganholi.cleanarch.core.dataprovider.UpdateCustomer;
import com.foganholi.cleanarch.core.domain.Customer;
import com.foganholi.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.foganholi.cleanarch.core.usecase.UpdateCustomerUseCase;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

	private final FindCustomerByIdUseCase findCustomerByIdUseCase;
	
	private final FindAddressByZipCode findAddressByZipCode;
	
	private final UpdateCustomer updateCustomer;

	public UpdateCustomerUseCaseImpl(FindCustomerByIdUseCase findCustomerByIdUseCase, FindAddressByZipCode findAddressByZipCode, UpdateCustomer updateCustomer) {
		this.findCustomerByIdUseCase = findCustomerByIdUseCase;
		this.findAddressByZipCode = findAddressByZipCode;
		this.updateCustomer = updateCustomer;
	}

	@Override
	public void update(Customer customer, String zipCode) {
		var oldCustomer = findCustomerByIdUseCase.find(customer.getId());
		var address = findAddressByZipCode.find(zipCode);
		customer.setAddress(address);
		updateCustomer.update(customer);
		
	}

}
