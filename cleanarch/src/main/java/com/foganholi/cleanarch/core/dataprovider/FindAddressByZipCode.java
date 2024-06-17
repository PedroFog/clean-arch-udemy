package com.foganholi.cleanarch.core.dataprovider;

import com.foganholi.cleanarch.core.domain.Address;

public interface FindAddressByZipCode {
	
	Address find(final String zipCode);

}
