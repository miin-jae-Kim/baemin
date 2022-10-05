package com.homes.baemin.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 64)
    @NotNull
    private String name;
}
