package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service(value = "todosService")
public class TodosServiceImplementation implements TodosService{
    @Autowired
    todosRepository todosRepos;

    @Transactional

    @Override
    public void markComplete(long todoid) {
        Todos toUpdate = todosRepos.findById(todoid)
                .orElseThrow(()->new EntityNotFoundException("Todos at id" + todoid + " not found"));

        toUpdate.setCompleted(!toUpdate.isCompleted());
        todosRepos.save(toUpdate);
    }
}
