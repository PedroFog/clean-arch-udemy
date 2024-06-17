package com.foganholi.cleanarch.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.foganholi.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.foganholi.cleanarch.core.domain.Address;
import com.foganholi.cleanarch.dataprovider.client.FindAddressByZipCodeClient;
import com.foganholi.cleanarch.dataprovider.client.mapper.AddressResponseMapper;

import jakarta.annotation.PostConstruct;

@Component
public class FindAddressByZipCodeImpl implements FindAddressByZipCode {

	@Autowired
	private FindAddressByZipCodeClient findAddressByZipCodeClient;

	@Autowired
	private AddressResponseMapper addressResponseMapper;

	@PostConstruct
	public void init() {
		System.out.println("AddressResponseMapper: " + addressResponseMapper);
	}

	@Override
	public Address find(String zipCode) {
		return addressResponseMapper.toAddress(findAddressByZipCodeClient.find(zipCode));
	}

}
