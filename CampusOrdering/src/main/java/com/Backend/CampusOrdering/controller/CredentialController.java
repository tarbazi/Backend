package com.Backend.CampusOrdering.controller;

import com.Backend.CampusOrdering.service.CredentialService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CredentialController {
    
    private CredentialService credentialService;

    @Autowired
    public CredentialController(CredentialService credentialService){
        this.credentialService = credentialService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createuser")
    public Map<String, Object> createUser(@RequestParam String studentnum, @RequestParam String password){
        return credentialService.createUser(studentnum, password);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/authenticate")
    public Map<String, Object> login(@RequestParam String studentnum, @RequestParam String password){
        return credentialService.login(studentnum, password);
    }

}
