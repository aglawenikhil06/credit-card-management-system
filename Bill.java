package com.orm.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="bill")
public class Bill {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "bill_id")
	    private Long billId;

	    @Column(name = "card_number", nullable = false)
	    private String cardNumber;

	    @Column(name = "total_amount")
	    private double totalAmount;

	    @Column(name = "bill_date")
	    private LocalDate billDate;

	    @Column(name = "due_date")
	    private LocalDate dueDate;

	    @Column(name = "paid")
	    private boolean paid;
}
