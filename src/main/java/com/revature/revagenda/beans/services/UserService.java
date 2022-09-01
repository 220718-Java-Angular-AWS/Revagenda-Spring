package com.revature.revagenda.beans.services;

import com.revature.revagenda.beans.repositories.UserRepo;
import com.revature.revagenda.entities.User;
import com.revature.revagenda.exceptions.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepo repo;
    ValidatorService validator;

    @Autowired
    public UserService(UserRepo userRepo, ValidatorService validatorService) {
        this.repo = userRepo;
        this.validator = validatorService;
    }

    //5 crud things:
    // GET - read - find,
    // GET - read all - find all,
    // POST - create - save,
    // PUT/PATCH - update - save,
    // DELETE - delete - delete

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return repo.findById(id);
    }

    public void createUser(User user) throws InvalidInputException {
        if(validator.validateUser(user)) {
            repo.save(user);
        } else {
            throw new InvalidInputException("this user has invalid data");
        }
    }

    public void updateUser(User user) {
        repo.save(user);
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }


}
