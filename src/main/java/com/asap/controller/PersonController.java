package com.asap.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.asap.entity.Address;
import com.asap.entity.Person;
import com.asap.repo.PersonRepository;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/save")
    public String savePerson(@RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("phone") String phone,
                             @RequestParam("houseNo") String houseNo,
                             @RequestParam("street") String street,
                             @RequestParam("city") String city,
                             @RequestParam("dateOfBirth") Date dateOfBirth,
                             @RequestParam("status") Person.Status status,
                             @RequestParam("profilePic") MultipartFile profilePic) {
        // create a new person object
        Address address = new Address(houseNo, street, city);
        Person person = new Person(name, email, phone, address, dateOfBirth, status);
        try {
            person.setProfilePic(profilePic.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // save the person to the database
        personRepository.save(person);
        return "redirect:/person/list";
    }
    
    @GetMapping("/list")
    public String listPersons(Model model) {
        List<Person> personList = personRepository.findAll();
        model.addAttribute("persons", personList);
        return "person-list";
    }

}

