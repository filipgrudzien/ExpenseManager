package com.expensetracker.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @Column(name = "expenseid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int expenseid;

    @Column(name = "budgetid")
    private int budgetid;

    @Column(name = "pricevalue")
    @NotNull(message = "Total price field cannot remain null!")
    @NotEmpty(message = "Total price field cannot remain blank!")
    private String pricevalue; /* type changed to String, later on there is a need to get sum of all prices (converting->summing) */

    @Column(name = "category")
    private String category;

    //https://www.baeldung.com/hibernate-date-time
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date; /* only month is going to be retrieved out of this date */

    @ManyToOne(fetch = FetchType.LAZY) /// late on need to evaluate proper fetch data type
    @JoinColumn(name = "budgetid")
    private Budget assignedBudget;
}
