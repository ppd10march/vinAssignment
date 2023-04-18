package com.jlr.vin.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VinValidator {

    List<String> getClaims(String vinNumber);

}
