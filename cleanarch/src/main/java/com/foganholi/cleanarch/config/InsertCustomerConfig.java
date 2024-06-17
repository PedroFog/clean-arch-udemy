package com.foganholi.cleanarch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.foganholi.cleanarch.core.usecase.impl.InsertCustomerUseCaseImpl;
import com.foganholi.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import com.foganholi.cleanarch.dataprovider.InsertCustomerImpl;
import com.foganholi.cleanarch.dataprovider.SendCpfForValidationImpl;

@Configuration
public class InsertCustomerConfig {

	@Bean
	InsertCustomerUseCaseImpl insertCustomerUseCaseImpl(FindAddressByZipCodeImpl findAddressByZipCode,
			InsertCustomerImpl insertCustomer, SendCpfForValidationImpl sendCpfForValidation) {
		return new InsertCustomerUseCaseImpl(findAddressByZipCode, insertCustomer, sendCpfForValidation);

	}

}
