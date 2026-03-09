package com.orm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.orm.entity.Transcation;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Transactional
public class TransactionDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

 // Save Transaction
    public Long saveTransaction(Transcation transaction) {
        return (Long) this.hibernateTemplate.save(transaction);
    }

    // View Transactions
    public List<Transcation> getAllTransactions() {
        return this.hibernateTemplate.loadAll(Transcation.class);
    }
}
