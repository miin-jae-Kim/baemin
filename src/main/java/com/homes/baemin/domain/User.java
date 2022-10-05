package com.homes.baemin.domain;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints = {
            @UniqueConstraint(name = "PHONE_UNIQUE", columnNames = {"phone"})
        })
public class User {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 64)
    @NotNull
    private String name;

    @Column
    @NotNull
    private int phone;
}
