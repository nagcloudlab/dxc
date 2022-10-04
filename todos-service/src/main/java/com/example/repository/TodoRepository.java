package com.example.repository;

import com.example.entity.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo,Long> {

    // DSL
    List<Todo> findByUserId(Long userId);

}
