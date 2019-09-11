package com.ruben_cepeda.customerProfile.controllers;

import com.google.common.collect.Lists;
import com.ruben_cepeda.customerProfile.entities.Customer;
import com.ruben_cepeda.customerProfile.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> create(@Valid @RequestBody final Customer customer) {
        final String email = customer.getEmail();
        final boolean present = customerRepository.findCustomerByEmailEquals(email).isPresent();
        if (present) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "already exists email: " + email);
        }
        return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> fetchAll(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "2") int size,
                                                   @RequestParam(defaultValue = "id") String sortBy) {
        final Pageable pageRequest = PageRequest.of(page, size, Sort.by(sortBy));
        final List<Customer> customers = Lists.newArrayList(customerRepository.findAll(pageRequest));
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> fetchById(@PathVariable long id) {
        final Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "id: " + id));
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> update(@PathVariable long id, @Valid @RequestBody final Customer customer) {
        customer.setId(id);
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Customer> delete(@PathVariable long id) {
        final Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "id: " + id));
        customerRepository.delete(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}