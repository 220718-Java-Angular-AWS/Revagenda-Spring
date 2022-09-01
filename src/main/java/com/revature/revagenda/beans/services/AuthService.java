package com.revature.revagenda.beans.services;

import com.revature.revagenda.beans.repositories.UserRepo;
import com.revature.revagenda.entities.User;
import com.revature.revagenda.exceptions.AccessDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private UserRepo repo;

    @Autowired
    public AuthService(UserRepo userRepo) {
        this.repo = userRepo;
    }

    public User authenticate(String username, String password) throws AccessDeniedException {
        Optional<User> result = repo.findByUsername(username);
        if(result.isPresent() && result.get().getPassword().equals(password)) {
            return result.get();
        } else {
            throw new AccessDeniedException("Username or password mismatch");
        }

    }



}
