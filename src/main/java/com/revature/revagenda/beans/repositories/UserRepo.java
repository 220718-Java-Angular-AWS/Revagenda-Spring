package com.revature.revagenda.beans.repositories;

import com.revature.revagenda.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
            /*
    Extending the CrudRepository (by way of JpaRepository) should implement the following CRUD operations for us:
    save()
    saveAll()
    findById()
    existsById()
    findAll()
    findAllById()
    count()
    deleteById()
    delete()
    deleteAll()
     */

    Optional<User> findByUsername(String username);

}
