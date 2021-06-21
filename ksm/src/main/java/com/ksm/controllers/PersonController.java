/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ksm.controllers;

import com.ksm.models.Person;
import com.ksm.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Qeisarcom
 */
@Controller
@RequestMapping("person")
public class PersonController {
    
    @Autowired
    private PersonService personService;
    
    @GetMapping
    public String index(Model model){
        model.addAttribute("persons",personService.getAll());
        model.addAttribute("title", "KSM - Person Web Page");
        return "person";
    }
    
    @GetMapping("/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        //System.out.println(personService.getById(id)); //ditampilkan di console
        model.addAttribute("person", personService.getById(id));
        model.addAttribute("title", "KSM - Person Detail");
        return "detail";
    }
    
    @GetMapping("/create")  //tempalte
    public String createForm(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("title", "KSM - Person Form");
        return "create-form";
    }
    
    @PostMapping("/create")  //action
    public String create(@ModelAttribute Person person, Model model) {
        personService.create(person);
        return "redirect:/person";
    }
    
    @GetMapping("/{id}/update")  //tempalte
    public String updateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("person", personService.getById(id));
        model.addAttribute("title", "KSM - Person Update Form");
        return "update-form";
    }
    
    @PostMapping("/{id}/update")  //action
    public String update(@PathVariable("id") Integer id,
            @ModelAttribute Person person, Model model) {
        personService.update(id, person);
        return "redirect:/person";  
    }
    
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Integer id) {
        personService.delete(id);
        return "redirect:/person";  
    }
}
