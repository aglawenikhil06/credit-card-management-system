package com.orm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.orm.entity.CreditCard;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Transactional
public class CreditCardDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    // Apply Credit Card
    public Long saveCreditCard(CreditCard card) {
        return (Long) this.hibernateTemplate.save(card);
    }

    // View all cards
    public List<CreditCard> getAllCards() {
        return this.hibernateTemplate.loadAll(CreditCard.class);
    }

    // Update card (for available limit)
    public void updateCard(CreditCard card) {
        this.hibernateTemplate.update(card);
    }
}
