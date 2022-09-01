package com.revature.revagenda.beans.services;

import com.revature.revagenda.entities.User;
import com.revature.revagenda.exceptions.InvalidInputException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidatorService {

    public boolean validateUser(User user) {
        boolean valid = true;

        //validate user email:
        if (user.getEmail() == null || !Pattern.matches("^[A-Za-z0-9\\.\\-_]+@[A-Za-z0-9\\-]+\\.[A-Za-z]{2,5}$", user.getEmail())) {
            valid = false;
        }
        if(user.getFirstName() == null || !Pattern.matches("^[A-Za-z' -\\.]{1,25}$", user.getFirstName())) {
            valid = false;
        }
        if(user.getLastName() == null || !Pattern.matches("^[A-Za-z' -\\.]{1,25}$", user.getFirstName())) {
            valid = false;
        }

        return valid;

    }

}
