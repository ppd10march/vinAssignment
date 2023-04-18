package com.jlr.vin;

import com.jlr.vin.service.VinValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class VinValidatorApplicationTests {

	@Autowired
	VinValidator vinValidator;

	@ParameterizedTest
	@ValueSource(strings = { "1G2NW52E74M585264"})
	public void validateVin(String vinNumber) {
		List<String> claims = vinValidator.getClaims(vinNumber);
		Assertions.assertTrue(claims.contains("SALVA2CN5JH302434"));
	}

	@ParameterizedTest
	@ValueSource(strings = { "1G2NW52E74M5852641A"})
	public void validateVin1(String vinNumber) {
		List<String> claims = vinValidator.getClaims(vinNumber);
		Assertions.assertTrue(claims.contains("SALVA2CN5JH302434"));
	}
}
