package com.fkhrayef.event.Controller;

import com.fkhrayef.event.Api.ApiResponse;
import com.fkhrayef.event.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/")
public class EventController {

    ArrayList<Event> events = new ArrayList<>();

    @GetMapping("get/events")
    public ArrayList<Event> getEvents(){
        return events;
    }

    @GetMapping("get/events/{id}")
    public Event getEventById(@PathVariable int id){
        for(Event e : events){
            if(e.getId() == id){
                return e;
            }
        }
        return null;
    }

    @PostMapping("add/event")
    public ApiResponse addEvent(@RequestBody Event event) {
        // Validations
        if(event.getCapacity() < 0) {
            return new ApiResponse("Capacity must be greater than 0!", "400");
        }
        if(event.getStartDate().isAfter(event.getEndDate())) {
            return new ApiResponse("Start Date must be before End Date!", "400");
        }
        for (Event e : events) {
            if (e.getId() == event.getId()) {
                return new ApiResponse("Event ID Already Exists!", "400");
            }
        }

        // Add event
        events.add(new Event(event.getId(), event.getDescription(), event.getCapacity(), event.getStartDate(), event.getEndDate()));
        return new ApiResponse("Event Added Successfully!", "200");
    }

    @PutMapping("update/events/{eventId}")
    public ApiResponse updateEvent(@PathVariable("eventId") int eventId, @RequestBody Event event) {
        // Validations
        if(event.getCapacity() < 0) {
            return new ApiResponse("Capacity must be greater than 0!", "400");
        }
        if(event.getStartDate().isAfter(event.getEndDate())) {
            return new ApiResponse("Start Date must be before End Date!", "400");
        }

        // Get the event by its id
        Event eventToUpdate = null;
        for (Event e : events) {
            if (e.getId() == eventId) {
                eventToUpdate = e;
                break;
            }
        }

        // If found, update it. If not, return not found!
        if (eventToUpdate != null) {
            eventToUpdate.setDescription(event.getDescription());
            eventToUpdate.setCapacity(event.getCapacity());
            eventToUpdate.setStartDate(event.getStartDate());
            eventToUpdate.setEndDate(event.getEndDate());
            return new ApiResponse("Event Updated Successfully!", "200");
        } else {
            return new ApiResponse("Event Not Found!", "404");
        }
    }

    @PutMapping("update/events/{eventId}/capacity")
    public ApiResponse changeCapacity(@PathVariable("eventId") int eventId, @RequestParam int capacity) {
        // Validations
        if(capacity < 0) {
            return new ApiResponse("Capacity must be greater than 0!", "400");
        }

        // Get the event by its id
        Event eventToUpdate = null;
        for (Event e : events) {
            if (e.getId() == eventId) {
                eventToUpdate = e;
                break;
            }
        }

        // If found, update the capacity. If not, return not found!
        if (eventToUpdate != null) {
            eventToUpdate.setCapacity(capacity);
            return new ApiResponse("Event Capacity Updated Successfully!", "200");
        } else {
            return new ApiResponse("Event Not Found!", "404");
        }

    }

    @DeleteMapping("delete/events/{eventId}")
    public ApiResponse deleteEvent(@PathVariable("eventId") int eventId) {
        // Get the event by its id
        Event eventToDelete = null;
        for (Event e : events) {
            if (e.getId() == eventId) {
                eventToDelete = e;
                break;
            }
        }

        // If found, delete it. If not, return not found!
        if (eventToDelete != null) {
            events.remove(eventToDelete);
            return new ApiResponse("Event Deleted Successfully!", "200");
        } else {
            return new ApiResponse("Event Not Found!", "404");
        }
    }

}
