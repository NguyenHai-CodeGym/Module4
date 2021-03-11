package com.hai.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Owner2Controller {

    @GetMapping("/owners/{ownerId}/pets/{petId}")
    public String findPet(@PathVariable Long ownerId, @PathVariable Long petId){
        return "index";
    }
}
