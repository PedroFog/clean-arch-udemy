package com.foganholi.cleanarch.dataprovider.repository.mapper;

import org.mapstruct.Mapper;

import com.foganholi.cleanarch.core.domain.Customer;
import com.foganholi.cleanarch.dataprovider.repository.entity.CustomerEntity;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

	CustomerEntity toCustomerEntity(Customer customer);
	
	Customer toCustomer(CustomerEntity customerEntity);
}
