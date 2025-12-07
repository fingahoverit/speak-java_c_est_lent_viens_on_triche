package com.example.quarkusnativedemo.service;

import com.example.quarkusnativedemo.model.Person;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class PersonService {

    @Inject
    EntityManager em;

    @Transactional
    public void save(Person person) {
        em.persist(person);
    }

    public List<Person> listAll() {
        return em.createQuery("FROM Person", Person.class).getResultList();
    }
}
