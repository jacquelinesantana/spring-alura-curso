package com.tijacque.clinicaMedica.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class OlaController {
    @GetMapping
    public String OlaMundo(){
        return "Olá mundo!!!";
    }
}
