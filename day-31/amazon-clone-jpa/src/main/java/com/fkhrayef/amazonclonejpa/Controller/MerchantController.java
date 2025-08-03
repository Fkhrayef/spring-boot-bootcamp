package com.fkhrayef.amazonclonejpa.Controller;

import com.fkhrayef.amazonclonejpa.Api.ApiResponse;
import com.fkhrayef.amazonclonejpa.Model.Merchant;
import com.fkhrayef.amazonclonejpa.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/merchants")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity<?> getMerchants() {
        List<Merchant> merchants = merchantService.getMerchants();

        if (!merchants.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(merchants);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No merchants yet. Try adding some!"));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMerchant(@Valid @RequestBody Merchant merchant, Errors errors) {
        // Check for validation errors
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors())
                errorMessages.add(error.getDefaultMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        // add merchant
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(HttpStatus.CREATED).body(merchant);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMerchant(@PathVariable("id") Integer id, @Valid @RequestBody Merchant merchant, Errors errors) {
        // Check for validation errors
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors())
                errorMessages.add(error.getDefaultMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        if(merchantService.updateMerchant(id, merchant)) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Merchant updated successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Merchant not found."));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMerchant(@PathVariable("id") Integer id) {
        if (merchantService.deleteMerchant(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Merchant not found."));
        }
    }

    // ===== EXTRA BUSINESS LOGIC ENDPOINT =====

    /**
     * EXTRA ENDPOINT #9: Merchant Rating & Ranking System
     * Provides top-rated merchants based on dynamic performance scoring algorithm.
     * Features: Real-time rating calculation, purchase/return impact weighting,
     *          top 5 merchant ranking, performance-based merchant discovery.
     * Scoring: +1 per purchase, -2 per return (incentivizes quality service)
     */
    @GetMapping("/get/top-merchants")
    public ResponseEntity<?> getTopMerchants() {
        List<Merchant> topMerchants = merchantService.getTopMerchants();

        if (!topMerchants.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(topMerchants);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No merchants found."));
        }
    }
}