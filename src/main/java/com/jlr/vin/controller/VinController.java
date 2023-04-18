package com.jlr.vin.controller;

import com.jlr.vin.service.VinValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/claims")
@Validated
public class VinController {

    @Autowired
    VinValidator vinValidator;

    @GetMapping("/{vinNumber}")
    public ResponseEntity<List<String>> validateVin(@Valid @Pattern(regexp = "^[A-Za-z0-9]{17}$", message = "VinNumber must be 17 alphanumeric characters") @Size(min = 17, max = 17, message = "VinNumber must be 17 characters in length") @PathVariable String vinNumber){
        List<String> claims = vinValidator.getClaims(vinNumber);
        return ResponseEntity.ok(claims);
    }
}
