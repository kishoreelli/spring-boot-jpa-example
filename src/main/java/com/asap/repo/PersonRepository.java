package com.asap.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asap.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // Optional additional methods 
}

