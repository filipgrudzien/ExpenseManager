package com.expensetracker.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @Column(name = "userid_fk")
    private int userid_fk; /* foreign key connecting with user table, later to-do */

    @Column(name = "money")
    @NotEmpty(message = "Money field cannot remain blank!")
    private String money; /* type changed to String, later on there is a need to get sum of all prices (converting->summing) */

    //https://www.baeldung.com/hibernate-date-time
    @Column(name = "timeperiod")
    @NotNull(message = "Date field cannot remain null!")
    @Temporal(TemporalType.DATE)
    private Date timeperiod; /* only month and year is going to be retrieved out of this date */

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true) /// late on need to evaluate proper fetch data type
    @JoinColumn(name = "budgetid_fk")
    private List<Expense> listOfAssignedExpenses = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY) /// late on need to evaluate proper fetch data type
    @JoinColumn(name = "userid")
    private User assignedUser;
}
