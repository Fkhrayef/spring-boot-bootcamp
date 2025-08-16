package com.fkhrayef.schoolmanagementsystem.Controller;

import com.fkhrayef.schoolmanagementsystem.Api.ApiResponse;
import com.fkhrayef.schoolmanagementsystem.DTO.AddressDTO;
import com.fkhrayef.schoolmanagementsystem.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllAddresses(){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAllAddresses());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAddress(@Valid @RequestBody AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Address added successfully"));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAddress(@Valid @RequestBody AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Address updated successfully"));
    }
}
