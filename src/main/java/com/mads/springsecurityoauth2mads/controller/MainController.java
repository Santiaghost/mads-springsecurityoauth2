package com.mads.springsecurityoauth2mads.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("/hello")
    public String Hello(){
        return "Hello";
    }

    @PreAuthorize("hasAuthority('administer')")
    @GetMapping("/msgSecreto")
    public String MensajeSecreto(){
        return "Mensaje Secreto";
    }

}
