package com.foganholi.cleanarch.dataprovider.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.foganholi.cleanarch.dataprovider.client.response.AddressResponse;

@FeignClient(name = "FindAddressByZipCodeClient", url = "${foganholi.client.address.url}")
public interface FindAddressByZipCodeClient {

	@GetMapping("/{zipCode}")
	AddressResponse find(@PathVariable("zipCode") String zipCode);

}
