package net.davzshaw.MsdProject.controllers;

import net.davzshaw.MsdProject.entities.User;
import net.davzshaw.MsdProject.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserServices userService;

    @Autowired
    public UserController(UserServices userService) {
        this.userService = userService;
    }
  
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = this.userService.createUser(user.getName(), user.getEmail(), user.getPassword());
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteByEmail(@RequestParam String email) {
        this.userService.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        User user = this.userService.findByEmail(email);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = this.userService.findAll();
        return ResponseEntity.ok(users);
    }
  
    @PostMapping("/authenticate")
    public ResponseEntity<Boolean> authenticate(@RequestBody User user) {
        boolean isAuthenticated = this.userService.authenticate(user.getEmail(), user.getPassword());
        return ResponseEntity.ok(isAuthenticated);
    }
}
