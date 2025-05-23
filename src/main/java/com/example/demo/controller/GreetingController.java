package com.example.demo.controller;
import com.example.demo.model.Greeting;
import com.example.demo.service.GreetingService;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/Greeting")
public class GreetingController {
	//uc1
	@GetMapping("/hello")
    public String sayHello() {
        return "Hello from BridgeLabz";
    }
	
	
    
}
