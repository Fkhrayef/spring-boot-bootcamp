package com.fkhrayef.day18;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/name")
    public String getName() {
        return "My name is Faisal ALkhrayef";
    }

    @GetMapping("/age")
    public String getAge() {
        return "My age is 22";
    }

    @GetMapping("/check/status")
    public String getStatus() {
        return "Everything OK";
    }

    @GetMapping("/health")
    public String getHealth() {
        return "Server health is up and running";
    }

    @GetMapping("/names")
    public String[] getNames() {
        return new String[] {"Faisal", "Ahmad", "Nasser"};
    }
}
