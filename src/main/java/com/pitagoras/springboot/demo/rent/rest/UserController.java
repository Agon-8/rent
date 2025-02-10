package com.pitagoras.springboot.demo.rent.rest;


import com.pitagoras.springboot.demo.rent.CustomerUserRequest;
import com.pitagoras.springboot.demo.rent.entity.Customer;
import com.pitagoras.springboot.demo.rent.entity.User;
import com.pitagoras.springboot.demo.rent.repository.CustomerRepository;
import com.pitagoras.springboot.demo.rent.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final CustomerRepository customerRepository;

    public UserController(UserService userService, CustomerRepository customerRepository) {
        this.userService = userService;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return this.userService.findById(id);
    }

}