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
    }//UC2
	@Autowired
	private GreetingService greetingService;

    @GetMapping
	public Greeting getgreeting() {
		return greetingService.GetGreetingMessage("get");
	}

	@PutMapping
	public Greeting putgreeting() {
		return greetingService.GetGreetingMessage("put");
	}

	@PostMapping
	public Greeting postgreeting() {
		return greetingService.GetGreetingMessage("post");
	}

	@DeleteMapping
	public Greeting deletegreeting() {
		return greetingService.GetGreetingMessage("delete");
	}
	//uc3
	@GetMapping("/custom")
	public Greeting getCustomGreeting(@RequestParam(required = false) String firstName,
	                                  @RequestParam(required = false) String lastName) {
	    return greetingService.getPersonalizedGreeting(firstName, lastName);
	}
	//uc4
	@PostMapping("/save")
	public Greeting saveGreeting(@RequestBody Greeting greeting) {
	    return greetingService.saveGreeting(greeting);
	}
	//uc5
	@GetMapping("/{id}")
	public Greeting getGreetingById(@PathVariable long id) {
	    return greetingService.findById(id);
	}
    //UC6
	@GetMapping("/all")
	public List<Greeting> getAllGreetings() {
	    return greetingService.getAllGreetings();
	}
	//uc7
	@PutMapping("/{id}")
	public Greeting updateGreeting(@PathVariable long id, @RequestBody Greeting updatedGreeting) {
	    return greetingService.updateGreeting(id, updatedGreeting);
	}
	//uc8
		@DeleteMapping("/{id}")
		public ResponseEntity<String> deleteGreeting(@PathVariable long id) {
		    greetingService.deleteGreeting(id);
		    return ResponseEntity.ok("Greeting deleted successfully.");
		}

    
}
