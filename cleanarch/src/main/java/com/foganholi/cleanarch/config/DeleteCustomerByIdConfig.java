package com.foganholi.cleanarch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.foganholi.cleanarch.core.usecase.impl.DeleteCustomerByIdUseCaseImpl;
import com.foganholi.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.foganholi.cleanarch.dataprovider.DeleteCustomerByIdImpl;

@Configuration
public class DeleteCustomerByIdConfig {

	@Bean
	DeleteCustomerByIdUseCaseImpl deleteCustomerByIdUseCase(FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
			DeleteCustomerByIdImpl DeleteCustomerById) {
		return new DeleteCustomerByIdUseCaseImpl(findCustomerByIdUseCase, DeleteCustomerById);
	}

}
