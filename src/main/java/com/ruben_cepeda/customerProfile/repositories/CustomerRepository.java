package com.ruben_cepeda.customerProfile.repositories;

import com.ruben_cepeda.customerProfile.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
