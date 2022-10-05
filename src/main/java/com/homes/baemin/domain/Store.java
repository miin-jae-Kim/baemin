package com.homes.baemin.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Store {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    @NotNull
    private String name;
}
