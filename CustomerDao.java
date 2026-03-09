package com.orm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.orm.entity.Customer;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Transactional
public class CustomerDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

 // Register Customer
    public Long saveCustomer(Customer customer) {
        return (Long) this.hibernateTemplate.save(customer);
    }

    // Get Customer by ID
    public Customer getCustomer(Long id) {
        return this.hibernateTemplate.get(Customer.class, id);
    }
}
