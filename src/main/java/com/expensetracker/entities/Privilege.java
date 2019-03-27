package com.expensetracker.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "privilege")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "privilege_id")
    private Long id;

    @Column(name = "privilege_name")
    private String privilege_name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
}
