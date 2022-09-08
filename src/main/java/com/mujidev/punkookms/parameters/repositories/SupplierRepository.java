package com.mujidev.punkookms.parameters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mujidev.punkookms.parameters.models.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    
}
