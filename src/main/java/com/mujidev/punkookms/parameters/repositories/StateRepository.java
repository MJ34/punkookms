package com.mujidev.punkookms.parameters.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mujidev.punkookms.parameters.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

    @Query(value = "select s from State s where " +
            "s.capital LIKE %?1% or s.capital like %?1% or s.name like %?1%")
    List<State> findByKeyword1(String keyword);

    @Query(value = "select s from State s where " +
            "concat(s.capital, s.code, s.details, s.name ) like %?1%")
    List<State> findByKeyword(String keyword);

}
