package com.jlr.vin.serviceImpl;

import com.jlr.vin.exception.MyCustomException;
import com.jlr.vin.service.VinValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VinValidatorImpl implements VinValidator {

    @Override
    public List<String> getClaims(String vinNumber) {
        //TODO - the pattern need to be moved to properties file
        if(vinNumber.length() != 17 && !vinNumber.matches("^[A-Za-z0-9]{17}$"))
            //TODO - The messages need to be moved to property files
            throw new MyCustomException("Vin Number must be 17 alphanumeric characters");
        List<String> claims = new ArrayList<>(Arrays.asList("SALVA2CN5JH302434", "1G2NW52E74M585264", "5YJ3E1EB2MF862281"));
        return claims;
    }
}
