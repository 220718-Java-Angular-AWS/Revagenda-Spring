package com.revature.revagenda.beans.controllers;

import com.revature.revagenda.beans.services.UserService;
import com.revature.revagenda.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService userService) {
        this.service = userService;
    }



    //5 crud things:
    // GET - read - find,
    // GET - read all - find all,
    // POST - create - save,
    // PUT/PATCH - update - save,
    // DELETE - delete - delete

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody User getUserById(@PathVariable Integer userId) {
        Optional<User> optionalUser = service.getUserById(userId);
        //TODO: Do the isPresent() check and throw exception if needed
        return optionalUser.get();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void createUser(@RequestBody User user) {
        service.createUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateUser(@RequestBody User user) {
        service.updateUser(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteUser(@PathVariable(name = "userId") Integer id) {
        service.deleteById(id);
    }

}
