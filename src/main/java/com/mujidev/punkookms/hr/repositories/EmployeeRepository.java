package com.mujidev.punkookms.hr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mujidev.punkookms.hr.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

        Employee findByUsername(String username);
    
        @Query(value = "select * from Employee e where e.firstname like %:keyword% or e.lastname like %:keyword%", nativeQuery = true)
        List<Employee> findByKeyword(@Param("keyword") String keyword);
    
        @Query(value = "SELECT city, count(*) FROM Employee GROUP BY city",
                nativeQuery = true)
        List<Object> getCountByCountry();
}
