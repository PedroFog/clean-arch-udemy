package com.foganholi.cleanarch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.foganholi.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.foganholi.cleanarch.core.usecase.impl.UpdateCustomerUseCaseImpl;
import com.foganholi.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import com.foganholi.cleanarch.dataprovider.UpdateCustomerImpl;

@Configuration
public class UpdateCustomerConfig {

	@Bean
	UpdateCustomerUseCaseImpl updateCustomerUseCase(FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
			FindAddressByZipCodeImpl findAddressByZipCode, UpdateCustomerImpl updateCustomer) {
		return new UpdateCustomerUseCaseImpl(findCustomerByIdUseCase, findAddressByZipCode, updateCustomer);
	}

}
