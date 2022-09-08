package com.mujidev.punkookms.parameters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mujidev.punkookms.parameters.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    
}
