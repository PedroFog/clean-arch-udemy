package com.foganholi.cleanarch.dataprovider.client.mapper;

import org.mapstruct.Mapper;

import com.foganholi.cleanarch.core.domain.Address;
import com.foganholi.cleanarch.dataprovider.client.response.AddressResponse;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

	Address toAddress(AddressResponse addressResponse);

}
