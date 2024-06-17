package com.foganholi.cleanarch.entrypoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foganholi.cleanarch.core.usecase.DeleteCustomerByIdUseCase;
import com.foganholi.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.foganholi.cleanarch.core.usecase.InsertCustomerUseCase;
import com.foganholi.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.foganholi.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import com.foganholi.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.foganholi.cleanarch.entrypoint.controller.response.CustomerResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	@Autowired
	private InsertCustomerUseCase insertCustomerUseCase;

	@Autowired
	private FindCustomerByIdUseCase findCustomerByIdUseCase;

	@Autowired
	private UpdateCustomerUseCase updateCustomerUseCase;

	@Autowired
	private DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;

	@Autowired
	private CustomerMapper customerMapper;

	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
		insertCustomerUseCase.insert(customerMapper.toCustomer(customerRequest), customerRequest.getZipCode());
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
		var customerResponse = customerMapper.toCustomerResponse(findCustomerByIdUseCase.find(id));
		return ResponseEntity.ok().body(customerResponse);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable final String id,
			@Valid @RequestBody CustomerRequest customerRequest) {
		var customer = customerMapper.toCustomer(customerRequest);
		customer.setId(id);
		updateCustomerUseCase.update(customer, customerRequest.getZipCode());
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable final String id) {
		deleteCustomerByIdUseCase.delete(id);
		return ResponseEntity.noContent().build();
	}

}
