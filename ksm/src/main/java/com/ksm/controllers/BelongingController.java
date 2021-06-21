/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ksm.controllers;

import com.ksm.models.Belonging;
import com.ksm.services.BelongingService;
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
@RequestMapping("belonging")
public class BelongingController {
    
    @Autowired
    private BelongingService belongingService;
    
    @GetMapping
    public String index(Model model){
        model.addAttribute("belongings",belongingService.getAll());
        model.addAttribute("title", "KSM - Belonging Web Page");
        return "belonging";
    }
    
    @GetMapping("/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        //System.out.println(personService.getById(id)); //ditampilkan di console
        model.addAttribute("belonging", belongingService.getById(id));
        model.addAttribute("title", "KSM - Belonging Detail");
        return "belonging-detail";
    }
    
    @GetMapping("/create")  //tempalte
    public String createForm(Model model) {
        model.addAttribute("belonging", new Belonging());
        model.addAttribute("title", "KSM - Belonging Form");
        return "belonging-form";
    }
    
    @PostMapping("/create")  //action
    public String create(@ModelAttribute Belonging belonging, Model model) {
        belongingService.create(belonging);
        return "redirect:/belonging";
    }
    
    @GetMapping("/{id}/update")  //tempalte
    public String updateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("belonging", belongingService.getById(id));
        model.addAttribute("title", "KSM - Belonging Update Form");
        return "belonging-update-form";
    }
    
    @PostMapping("/{id}/update")  //action
    public String update(@PathVariable("id") Integer id,
            @ModelAttribute Belonging belonging, Model model) {
        belongingService.update(id, belonging);
        return "redirect:/belonging";  
    }
    
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Integer id) {
        belongingService.delete(id);
        return "redirect:/belonging";  
    }
}
