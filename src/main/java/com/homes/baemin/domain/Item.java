package com.homes.baemin.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "STORE_ID")
    private Store store;

    @Column(length = 64)
    @NotNull
    private String name;

    @Column
    @NotNull
    private int price;
}
