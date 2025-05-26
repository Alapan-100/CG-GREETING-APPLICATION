package com.example.demo.service;

import com.example.demo.model.Greeting;
import com.example.demo.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public Greeting saveGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Greeting GetGreetingMessage(String type) {
        switch(type.toLowerCase()) {
            case "post":
                return new Greeting(2, "Hello from POST(via Service)");
            case "put":
                return new Greeting(3, "Hello from PUT(via Service)");
            case "delete":
                return new Greeting(4, "Hello from DELETE(via Service)");
            default:
                return new Greeting(1, "Hello from GET(via Service)");
        }
}

    public Greeting getPersonalizedGreeting(String firstName, String lastName) {
        String message;

        if (firstName != null && lastName != null) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello, Mr/Ms. " + lastName + "!";
        } else {
            message = "Hello World";
        }

        return new Greeting(100, message);
    }

    public Greeting findById(long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found"));
    }

    public Greeting save(Greeting greeting) {
        return greetingRepository.save(greeting);
    }
    public Greeting updateGreeting(long id, Greeting updatedGreeting) {
        Greeting existingGreeting = greetingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found"));

        existingGreeting.setMessage(updatedGreeting.getMessage());

        return greetingRepository.save(existingGreeting);
    }
    public void deleteGreeting(long id) {
        greetingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found"));

        greetingRepository.deleteById(id); 
    }
}
