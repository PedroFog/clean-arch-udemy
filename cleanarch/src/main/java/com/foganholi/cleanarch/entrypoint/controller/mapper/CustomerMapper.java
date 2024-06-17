package com.foganholi.cleanarch.entrypoint.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.foganholi.cleanarch.core.domain.Customer;
import com.foganholi.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.foganholi.cleanarch.entrypoint.controller.response.CustomerResponse;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "address", ignore = true)
	@Mapping(target = "isValidCpf", ignore = true)
	Customer toCustomer(CustomerRequest customerRequest);
	
	CustomerResponse toCustomerResponse(Customer customer);

}
