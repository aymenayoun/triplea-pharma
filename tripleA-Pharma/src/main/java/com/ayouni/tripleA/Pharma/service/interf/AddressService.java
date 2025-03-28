package com.ayouni.tripleA.Pharma.service.interf;

import com.ayouni.tripleA.Pharma.dto.AddressDto;
import com.ayouni.tripleA.Pharma.dto.Response;

public interface AddressService {
    Response saveAndUpdateAddress(AddressDto addressDto);
}
