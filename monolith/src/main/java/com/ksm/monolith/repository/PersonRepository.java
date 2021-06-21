/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ksm.monolith.repository;

import com.ksm.monolith.model.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Qeisarcom
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    
    @Query (nativeQuery = true,
            value = "SELECT * FROM person WHERE gender = 'Female'")
    public List<Person> findAllFemales();
}
