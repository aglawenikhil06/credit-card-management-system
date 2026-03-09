package com.orm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.orm.entity.Payment;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Transactional
public class PaymentDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

 // Pay Bill
    public Long savePayment(Payment payment) {
        return (Long) this.hibernateTemplate.save(payment);
    }
}
