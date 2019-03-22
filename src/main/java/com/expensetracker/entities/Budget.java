package com.expensetracker.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

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

}
