package com.homes.baemin.repository;

import com.homes.baemin.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public User findById(Long id) {
        User user = em.find(User.class, id);
        System.out.println("user = " + user);
        return user;
    }

    public void save(User user) {
        em.persist(user);
    }
}