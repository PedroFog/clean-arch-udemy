package com.foganholi.cleanarch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.foganholi.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.foganholi.cleanarch.dataprovider.FindCustomerByIdImpl;

@Configuration
public class FindCustomerByIdConfig {

	@Bean
	FindCustomerByIdUseCaseImpl FindCustomerByIdUseCaseImpl(FindCustomerByIdImpl findCustomerById) {
		return new FindCustomerByIdUseCaseImpl(findCustomerById);

	}

}
