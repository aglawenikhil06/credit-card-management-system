package com.orm.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="credit_card")
public class CreditCard {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "card_id")
	    private Long cardId;

	    @Column(name = "card_number", unique = true, nullable = false)
	    private String cardNumber;

	    @Column(name = "credit_limit")
	    private double creditLimit;

	    @Column(name = "available_limit")
	    private double availableLimit;

	    @ManyToOne
	    @JoinColumn(name = "customer_id")
	    private Customer customer;
}
