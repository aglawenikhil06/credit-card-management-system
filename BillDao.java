package com.orm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.orm.entity.Bill;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Transactional
public class BillDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

 // Generate Bill
    public Long saveBill(Bill bill) {
        return (Long) this.hibernateTemplate.save(bill);
    }

    // Get Bill
    public Bill getBill(Long id) {
        return this.hibernateTemplate.get(Bill.class, id);
    }

    // Update Bill (paid true)
    public void updateBill(Bill bill) {
        this.hibernateTemplate.update(bill);
    }
}
