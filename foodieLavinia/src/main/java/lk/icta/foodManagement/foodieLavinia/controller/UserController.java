package lk.icta.foodManagement.foodieLavinia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lk.icta.foodManagement.foodieLavinia.entity.User;
import lk.icta.foodManagement.foodieLavinia.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;


@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping({ "/api/user" })
public class UserController {
	
	// Repository for managing User entities
    private final UserRepository userRepository;
    
    @Autowired
    // Constructor injection of UserRepository
    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    // Endpoint for user registration
    @PostMapping({ "/register" })
    public ResponseEntity<String> registerUser(@RequestBody final User user) {
    	
    	// Check if username already exists
        if (this.userRepository.findByUserName(user.getUserName()) != null) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
       // Save the user to the repository
        this.userRepository.save(user);
        return ResponseEntity.ok("Registration successful");
    }
    
    // Endpoint for user login
    @PostMapping({ "/login" })
    public ResponseEntity<String> loginUser(@RequestBody final User user) {
    	
    	 // Find user by username in the repository
        final User existingUser = this.userRepository.findByUserName(user.getUserName());
        // Check if the user exists and the password matches
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok("Login successful");
        }
        // Return unauthorized status if login fails
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
}
