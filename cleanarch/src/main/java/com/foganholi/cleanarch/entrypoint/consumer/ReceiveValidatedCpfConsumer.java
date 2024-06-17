package com.foganholi.cleanarch.entrypoint.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.foganholi.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.foganholi.cleanarch.entrypoint.consumer.mapper.CustomerMessageMapper;
import com.foganholi.cleanarch.entrypoint.consumer.message.CustomerMessage;

@Component
public class ReceiveValidatedCpfConsumer {

	@Autowired
	private UpdateCustomerUseCase updateCustomerUseCase;

	@Autowired
	private CustomerMessageMapper customerMessageMapper;

	@KafkaListener(topics = "tp-cpf-validated", groupId = "foganholi")
	public void receive(CustomerMessage customerMessage) {
		updateCustomerUseCase.update(customerMessageMapper.toCustomer(customerMessage), customerMessage.getZipCode());
	}

}
