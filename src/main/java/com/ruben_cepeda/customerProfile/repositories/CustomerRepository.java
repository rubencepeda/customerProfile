package com.ruben_cepeda.customerProfile.repositories;

import com.ruben_cepeda.customerProfile.entities.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Optional<Customer> findCustomerByEmailEquals(String email);
}
