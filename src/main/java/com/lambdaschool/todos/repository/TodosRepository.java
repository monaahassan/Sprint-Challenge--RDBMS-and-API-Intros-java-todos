package com.lambdaschool.todos.repository;

import org.springframework.data.repository.CrudRepository;

public interface TodosRepository extends CrudRepository<Todos, long> {
}
