/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ksm.monolith.controller;

import com.ksm.monolith.model.Person;
import com.ksm.monolith.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Qeisarcom
 */


@RestController //Restful API
@RequestMapping("api/person") // localhost:8080/api/person
public class PersonController {

    @Autowired
    PersonService personService;

    /**
     * - GET    -> getAll() 
     * - GET    -> getById() 
     * - POST    -> save(Person person) 
     * - PUT    -> saveNewLastName(Integer id, String lastName) 
     * - DELETE    -> delete(Integer id)
     */
    
    @GetMapping()
    public List<Person> getAll(){
        return personService.getAllPerson();
    }
    
    @GetMapping("/{id}") //localhost:8080/api/person/1
    public Person getById(@PathVariable Integer id){
        return personService.getById(id);
    }
    
    @PostMapping()
    public Person save(@RequestBody Person person){
        return personService.insert(person);
    }
    
    @PutMapping("/{id}") // Put [..] -> Mudjiarto, Patch Kelana -> Mudjiarto
    public Person save(@PathVariable Integer id, @RequestBody Person person){
        return personService.update(id, person);
    }
    
    @DeleteMapping("/{id}")
    public Person delete(@PathVariable Integer id){
        return personService.deleteById(id);
    }
}



/*

@Controller
@RequestMapping("person")   //localhost:8080/person         //localhost:8080    -->kosong, langsung ke index.html 
public class PersonController {
    
    @Autowired
    PersonService personService;
    
    @GetMapping("")
    public String tampilanHome(){
        personService.dummyData();
        return "person"; //person.html
    }
    
    @GetMapping("list")
    public String personList(){
        List<Person> people = personService.getAllPerson();
        
        for (Person person : people){
            System.out.println(person.getId());
            System.out.println(person.getFirstName());
            System.out.println(person.getLastName());
            System.out.println(person.getGender());
        }
        return "person";
    }
    
    @GetMapping("females")
    public String femaleList(){
        //String gender = "Female"; 
        List<Person> people = personService.findAllFemales();
        
        for (Person person : people){
            System.out.println(person.getId()+" : "+person.getFirstName()+" "+person.getLastName()+" ("+person.getGender()+")");
        }
        return "person";
    }
    
    
    @GetMapping("listById")
    public String personById(){
        int id = 4;
        Person person = personService.getPersonById(id);
        System.out.println(person.getId()+" : "+person.getFirstName()+" "+person.getLastName()+" ("+person.getGender()+")");
        return "person";
    }
    
    
    @GetMapping("update")
    public String updatePerson(){
        int id = 3;
        personService.updatePersonById(id);
        System.out.println("Person [ id = "+id+" ] updated");
        return "person";
    }
    
    
    @GetMapping("delete/{id}")
    public String deletePerson(@PathVariable Integer id){
        personService.deletePersonById(id);
        System.out.println("Person [ id = "+id+" ] deleted");
        return "person";
    }
    
    
}*/
