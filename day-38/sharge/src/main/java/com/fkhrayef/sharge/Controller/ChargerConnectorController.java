package com.fkhrayef.sharge.Controller;

import com.fkhrayef.sharge.Api.ApiResponse;
import com.fkhrayef.sharge.Model.ChargerConnector;
import com.fkhrayef.sharge.Service.ChargerConnectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/charger-connectors")
@RequiredArgsConstructor
public class ChargerConnectorController {

    private final ChargerConnectorService chargerConnectorService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllChargerConnectors() {
        return ResponseEntity.status(HttpStatus.OK).body(chargerConnectorService.getAllChargerConnectors());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addChargerConnector(@Valid @RequestBody ChargerConnector chargerConnector) {

        chargerConnectorService.addChargerConnector(chargerConnector);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("ChargerConnector added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateChargerConnector(@PathVariable("id") Integer id, @Valid @RequestBody ChargerConnector chargerConnector) {

        chargerConnectorService.updateChargerConnector(id, chargerConnector);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("ChargerConnector updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteChargerConnector(@PathVariable("id") Integer id) {
        chargerConnectorService.deleteChargerConnector(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
