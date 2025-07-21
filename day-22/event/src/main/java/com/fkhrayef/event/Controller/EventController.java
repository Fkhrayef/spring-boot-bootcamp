package com.fkhrayef.event.Controller;

import com.fkhrayef.event.Model.Event;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/")
public class EventController {
    ArrayList<Event> events = new ArrayList<>();

    @GetMapping("get/events")
    public ResponseEntity<?> getAllEvents(){
        return ResponseEntity.status(HttpStatus.OK).body(events);
    }

    @GetMapping("get/events/{eventIndex}")
    public ResponseEntity<?> getEventByIndex(@PathVariable int eventIndex){
        // Validate correct index
        if (eventIndex < 0 || eventIndex >= events.size()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Event index is out of bounds");
        }
        return ResponseEntity.status(HttpStatus.OK).body(events.get(eventIndex));
    }

    @PostMapping("add/event")
    public ResponseEntity<?> addEvent(@Valid @RequestBody Event event, Errors errors) {
        // Check for validation errors
        if (errors.hasErrors()) {
            // I want to get fancy and get all error messages (if exist), not just one.
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        // add event
        events.add(event);
        return ResponseEntity.status(HttpStatus.CREATED).body("Event added successfully");
    }

    @PutMapping("update/events/{eventIndex}")
    public ResponseEntity<?> updateEvent(@PathVariable("eventIndex") int eventIndex, @Valid @RequestBody Event event, Errors errors) {
        // Validate correct index
        if (eventIndex < 0 || eventIndex >= events.size()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Event index is out of bounds");
        }
        // Check for validation errors
        if (errors.hasErrors()) {
            // I want to get fancy and get all error messages (if exist), not just one.
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        // update event
        events.set(eventIndex, event);
        return ResponseEntity.status(HttpStatus.OK).body("Event updated successfully");
    }

    @PutMapping("update/events/{eventIndex}/capacity")
    public ResponseEntity<?> changeCapacity(@PathVariable("eventIndex") int eventIndex, @RequestParam Integer capacity) {
        // Validate correct index
        if (eventIndex < 0 || eventIndex >= events.size()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Event index is out of bounds");
        }
        // Check for validation errors (Manually since we can't use @Valid on capacity)
        if (capacity == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Capacity cannot be null");
        }
        if (capacity <= 25) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Capacity must be greater than 25");
        }
        Event event = events.get(eventIndex);
        event.setCapacity(capacity);
        return ResponseEntity.status(HttpStatus.OK).body("Event capacity updated successfully");
    }

    @DeleteMapping("delete/events/{eventIndex}")
    public ResponseEntity<?> deleteEvent(@PathVariable("eventIndex") int eventIndex) {
        // Validate correct index
        if (eventIndex < 0 || eventIndex >= events.size()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Event index is out of bounds");
        }
        events.remove(eventIndex);
        return ResponseEntity.status(HttpStatus.OK).body("Event deleted successfully");
    }


}
