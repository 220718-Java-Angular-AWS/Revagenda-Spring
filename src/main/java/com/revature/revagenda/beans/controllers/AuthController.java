package com.revature.revagenda.beans.controllers;

import com.revature.revagenda.beans.services.AuthService;
import com.revature.revagenda.dtos.Principal;
import com.revature.revagenda.entities.User;
import com.revature.revagenda.exceptions.AccessDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    private AuthService service;

    @Autowired
    public AuthController(AuthService authService) {
        this.service = authService;
    }


    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public User authenticate(@RequestBody Principal principal) throws AccessDeniedException{
        return service.authenticate(principal.getUsername(), principal.getPassword());
    }
}
