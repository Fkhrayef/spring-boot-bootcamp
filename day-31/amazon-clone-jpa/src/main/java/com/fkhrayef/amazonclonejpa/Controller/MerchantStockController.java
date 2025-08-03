package com.fkhrayef.amazonclonejpa.Controller;

import com.fkhrayef.amazonclonejpa.Api.ApiResponse;
import com.fkhrayef.amazonclonejpa.Model.MerchantStock;
import com.fkhrayef.amazonclonejpa.Service.MerchantStockService;
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
@RequestMapping("/api/v1/merchant-stocks")
@RequiredArgsConstructor
public class MerchantStockController {

    private final MerchantStockService merchantStockService;

    @GetMapping("/get")
    public ResponseEntity<?> getMerchantStocks() {
        List<MerchantStock> merchantStocks = merchantStockService.getMerchantStocks();
        if (!merchantStocks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(merchantStocks);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No merchantStocks yet. Try adding some!"));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMerchantStock(@Valid @RequestBody MerchantStock merchantStock, Errors errors) {
        // Check for validation errors
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors())
                errorMessages.add(error.getDefaultMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        // add merchantStock
        Integer status = merchantStockService.addMerchantStock(merchantStock);
        if (status == 1) {
            return ResponseEntity.status(HttpStatus.CREATED).body(merchantStock);
        } else if (status == 2) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Product not found."));
        } else if(status == 4) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Stock must be more than 10 at start."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Merchant not found."));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMerchantStock(@PathVariable("id") Integer id, @Valid @RequestBody MerchantStock merchantStock, Errors errors) {
        // Check for validation errors
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors())
                errorMessages.add(error.getDefaultMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        Integer status = merchantStockService.updateMerchantStock(id, merchantStock);
        if (status == 1) {
            return ResponseEntity.status(HttpStatus.OK).body(merchantStock);
        }  else if (status == 2) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Product not found."));
        } else if (status == 3) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("MerchantStock not found."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Merchant is not found."));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMerchantStock(@PathVariable("id") Integer id) {
        if (merchantStockService.deleteMerchantStock(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("MerchantStock not found."));
        }
    }

    @PutMapping("/add-stock/{productId}/{merchantId}/{amount}")
    public ResponseEntity<?> addStock(@PathVariable("productId") Integer productId, @PathVariable("merchantId") Integer merchantId, @PathVariable("amount") Integer amount) {
        Integer status = merchantStockService.addStock(merchantId, productId, amount);

        if (status == 1) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Added stock successfully."));
        } else if (status == 2) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Added amount must be positive."));
        } else if (status == 3) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Merchant not found."));
        } else if (status == 4) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Product not found."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("MerchantStock not found."));
        }
    }
}
