/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ksm.monolith.service;

import com.ksm.monolith.model.Belonging;
import com.ksm.monolith.repository.BelongingRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Qeisarcom
 */
@Service
public class BelongingService {
    
    @Autowired //dependency injection 
    BelongingRepository belongingRepository;
    
     public Belonging insert(Belonging belonging) {
        if (belonging.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Data already exists");
        }
        return belongingRepository.save(belonging);
    }
    
    //Read All
    public List<Belonging> getAllBelonging(){
        List<Belonging> belongings = belongingRepository.findAll();
        return belongings;
    }
    
    public void dummyData() {
        List<Belonging> belonging = new ArrayList<>();

        belonging.add(new Belonging("Gunting", 20));
        belonging.add(new Belonging("Buku",13));
        belongingRepository.saveAll(belonging);
    }
    
    public Belonging getById(Integer id) {
        if (belongingRepository.existsById(id)) {
            return belongingRepository.findById(id).get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Data");
    }
    
    public Belonging update(Integer id, Belonging belonging) {
        Belonging oldBelonging = getById(id);
        oldBelonging.setName(belonging.getName());
        oldBelonging.setQuantity(belonging.getQuantity());
        oldBelonging.setPerson(belonging.getPerson());

        return belongingRepository.save(oldBelonging);
    }

    //Delete -> deleteById(Integer id)
    public Belonging deleteById(Integer id) {
        Belonging belonging = getById(id);
        belongingRepository.delete(belonging);
        return belonging;
    }
    
}
