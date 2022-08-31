package com.revature.revagenda.beans.services;

import com.revature.revagenda.beans.repositories.TaskRepo;
import com.revature.revagenda.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    TaskRepo repo;

    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.repo = taskRepo;
    }

    //5 crud things:
    // GET - read - find,
    // GET - read all - find all,
    // POST - create - save,
    // PUT/PATCH - update - save,
    // DELETE - delete - delete

    public Optional<Task> getTaskById(Integer id) {
        return repo.findById(id);
    }

    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    public void createTask(Task task) {
        repo.save(task);
    }

    public void updateTask(Task task) {
        repo.save(task);
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

}
