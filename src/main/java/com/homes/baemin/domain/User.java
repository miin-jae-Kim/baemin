package com.homes.baemin.domain;


import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints = {
            @UniqueConstraint(name = "PHONE_UNIQUE", columnNames = {"phone"})
        })
@Getter
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
