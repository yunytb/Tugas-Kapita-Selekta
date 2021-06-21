/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ksm.monolith.service;
import com.ksm.monolith.model.Person;
import com.ksm.monolith.repository.PersonRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Qeisarcom
 */
@Service
public class PersonService {
    
    @Autowired //dependency injection 
    PersonRepository personRepository;

    
        //Create
    public Person insert(Person person) {
        if (person.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Data already exists");
        }
        return personRepository.save(person);
    }

    //Read All
    public List<Person> getAllPerson() {
        List<Person> people = personRepository.findAll();
        return people;
    }

    public void dummyData() {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Aqira", "Kelana","Male"));
        people.add(new Person("Kevin", "Harlim","Male"));
        people.add(new Person("Lois", "Ceka","Male"));
        personRepository.saveAll(people);
    }

    //Read -> getById(Integer id) -> findById(id)
    public Person getById(Integer id) {
        if (personRepository.existsById(id)) {
            return personRepository.findById(id).get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Data");
    }

    //Update -> update(Integer id) -> 1 Kevin Harlim
    public Person update(Integer id, Person person) {
        Person oldPerson = getById(id);
        oldPerson.setFirstName(person.getFirstName());
        oldPerson.setLastName(person.getLastName());
        oldPerson.setGender(person.getGender());

        return personRepository.save(oldPerson);
    }

    //Delete -> deleteById(Integer id)
    public Person deleteById(Integer id) {
        Person person = getById(id);
        personRepository.delete(person);
        return person;
    }
    
    
    
    
    
    /*
     //Create
    public boolean save(Person person) {
        Person p = personRepository.save(person);
        return personRepository.existsById(p.getId());
    }
    
    //Read All
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }
    
    public void dummyData() {
        List<Person> people = new ArrayList<>();
        
        people.add(new Person("Aqira", "Kelana", "Male"));
        people.add(new Person("Kevin", "Harlim", "Male"));
        people.add(new Person("Lois", "Ceka", "Male"));
        people.add(new Person ("Yuny", "Bota", "Female"));
        people.add(new Person ("Yuki", "Kato", "Female"));
        personRepository.saveAll(people);
    }
    
    public List<Person> findAllFemales(){
        return personRepository.findAllFemales();
    }

    //Read -> getById(Integer id) -> findById(id)
    public Person getPersonById(Integer id){
        Optional<Person> personResponse = personRepository.findById(id);    
        Person person = personResponse.get();
        return person;
    }
   
    //Update -> update(Integer id)
    public void updatePersonById(Integer id){
        Person person = new Person(id);
        person.setFirstName("Taylor");
        person.setLastName("Swift");
        person.setGender("Female");
        personRepository.save(person);
    }

    //Delete -> deleteById(Integer id)
    public void deletePersonById(Integer id){
        personRepository.deleteById(id);
    }
    */

}
