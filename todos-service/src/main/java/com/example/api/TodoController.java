package com.example.api;

import com.example.entity.Todo;
import com.example.entity.TodoType;
import com.example.excpetion.NotFoundException;
import com.example.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/todos/")
@RequiredArgsConstructor
public class TodoController {

    private static Map<Integer, Todo> todosMap = new HashMap<>();

    static {
        todosMap.put(1, new Todo(1, "First Todo", true, TodoType.OFFICE));
        todosMap.put(2, new Todo(2, "Second Todo", false, TodoType.HOME));
        todosMap.put(3, new Todo(3, "Third Todo", false, TodoType.OFFICE));
    }

    // rest-api implementation

    @GetMapping(
            produces = "application/json",
            params = {"!type"},
            headers = {"My-Header"}
    )
    public ResponseEntity<?> getAllTodos(
            @RequestHeader(value = "My-Header") String myHeader
    ) {
        System.out.println(myHeader);
        Iterable<Todo> todos = todosMap.values();
        return ResponseEntity.ok(todos);
    }

    @GetMapping(
            produces = "application/json",
            params = {"type", "!foo"}
    )
    public ResponseEntity<?> getFilteredTodos(
            @RequestParam(value = "type", required = true) String type
    ) {
        Iterable<Todo> todos = todosMap
                .values()
                .stream()
                .filter(todo -> todo.getType().equals(TodoType.valueOf(type.toUpperCase())))
                .collect(Collectors.toList());
        return ResponseEntity.ok(todos);
    }

    @GetMapping(
            value = "/{id}",
            produces = "application/json"
    )
    public ResponseEntity<?> getTodo(@PathVariable("id") Integer id) {
        Todo todo = todosMap.get(id);
        if(todo == null) {
            throw new NotFoundException("No todos found for id: "+id);
        }
        return ResponseEntity.ok(todo);
    }

    @ExceptionHandler(value = {
            NotFoundException.class,
    })
    public ResponseEntity<?> handleNotFoundException(Throwable e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
