package com.pitagoras.springboot.demo.rent.rest;


import com.pitagoras.springboot.demo.rent.CustomerUserRequest;
import com.pitagoras.springboot.demo.rent.entity.Customer;
import com.pitagoras.springboot.demo.rent.entity.User;
import com.pitagoras.springboot.demo.rent.repository.UserRepository;
import com.pitagoras.springboot.demo.rent.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final UserRepository userRepository;

    public CustomerController(CustomerService customerService, UserRepository userRepository) {
        this.customerService = customerService;
        this.userRepository = userRepository;
    }

    @PostMapping()
    public Customer save(CustomerUserRequest customer){
        Customer c = new Customer();
        c.setPersonalNumber(c.getPersonalNumber());
        c.setPhoneNumber(c.getPhoneNumber());
        User u = new User();
        u.setName(u.getUsername());
        u.setEmail(u.getEmail());
        c.setUser(u);
        this.userRepository.save(u);
        return this.customerService.save(c);
    }
}
