package com.expensetracker.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleid")
    private Long roleid;

    @Column(name = "role_name")
    private String role_name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @ManyToMany
    @JoinTable(
            name="roles_privileges",
            joinColumns = @JoinColumn(name = "roleid"),
            inverseJoinColumns = @JoinColumn(name = "privilegeid"))
    private Collection<Privilege> privileges;
}
