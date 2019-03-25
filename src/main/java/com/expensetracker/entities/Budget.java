package com.expensetracker.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "budget")
public class Budget {

    @Id
    @Column(name = "budgetid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int budgetid;

    @Column(name = "userid")
    private int userid; /* foreign key connecting with user table, later to-do */

    @Column(name = "money")
    private float money; /* later on, might considering change type to string */

    //https://www.baeldung.com/hibernate-date-time
    @Column(name = "timeperiod")
    @Temporal(TemporalType.DATE)
    private Date timeperiod; /* only month and year is going to be retrieved out of this date */

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true) /// late on need to evaluate proper fetch data type
    @JoinColumn(name = "budgetid")
    private List<Expense> listOfAssignedExpenses = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY) /// late on need to evaluate proper fetch data type
    @JoinColumn(name = "budgetid")
    private User assignedUser;
}
