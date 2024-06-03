package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String listPersons(Model model) {
        model.addAttribute("Persons", personService.findAllPersons());
        return "index";
    }

    @GetMapping("/add")
    public String showAddPersonForm(Model model) {
        model.addAttribute("Person", new Person());
        return "add-Person";
    }

    @PostMapping("/add")
    public String addPerson(@ModelAttribute Person Person) {
        personService.savePerson(Person);
        return "redirect:/";
    }

    @GetMapping("/transaction")
    public String testTransaction() {
        try {
            personService.transactionalMethodExample();
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        return "redirect:/";
    }
}
