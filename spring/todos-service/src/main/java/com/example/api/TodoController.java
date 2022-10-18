package com.example.api;

import com.example.entity.Todo;
import com.example.entity.TodoType;
import com.example.entity.User;
import com.example.excpetion.NotFoundException;
import com.example.repository.TodoRepository;
import com.example.repository.UserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/todos")
@RequiredArgsConstructor
public class TodoController {

//    private static Map<Long, Todo> todosMap = new HashMap<>();
//    static {
//        todosMap.put(1L, new Todo(1L, "First Todo", true, TodoType.OFFICE));
//        todosMap.put(2L, new Todo(2L, "Second Todo", false, TodoType.HOME));
//        todosMap.put(3L, new Todo(3L, "Third Todo", false, TodoType.OFFICE));
//    }

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @GetMapping(
            produces = "application/json",
            params = {"!type"},
            headers = {"!My-Header"}
    )
    public ResponseEntity<?> getAllTodos() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String userName= (String) authentication.getPrincipal();
        User user= userRepository.findByUsername(userName);
        Iterable<Todo> todos = todoRepository.findByUserId(user.getId());
        return ResponseEntity.ok(todos);
    }

    @GetMapping(
            produces = "application/json",
            params = {"type", "!foo"}
    )
    public ResponseEntity<?> getFilteredTodos(
            @RequestParam(value = "type", required = true) String type
    ) {
        Iterable<Todo> todos = todoRepository.findAll();
        StreamSupport.stream(todos.spliterator(), false)
                .filter(todo -> todo.getType().equals(TodoType.valueOf(type.toUpperCase())))
                .collect(Collectors.toList());
        return ResponseEntity.ok(todos);
    }

    @GetMapping(
            value = "/{id}",
            produces = "application/json"
    )
    public ResponseEntity<?> getTodo(@PathVariable("id") Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        Todo todo = optionalTodo.orElseThrow(() -> new NotFoundException("No todos found for id: " + id));
        return ResponseEntity.ok(todo);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.HEAD
    )
    public ResponseEntity<?> getHead(@PathVariable("id") Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Last-Modified", LocalTime.now().toString());
        return new ResponseEntity<>(null, headers, HttpStatus.OK);
    }

    @PostMapping(
            consumes = "application/json"
    )
    public ResponseEntity<?> createTodo(@RequestBody Todo todo) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        UserDetails userDetails= (UserDetails) authentication.getPrincipal();
        User user=userRepository.findByUsername(userDetails.getUsername());
        todo.setUser(user);
        Todo todo1 = todoRepository.save(todo);
        return new ResponseEntity<>(todo1, HttpStatus.CREATED);
    }

    @PutMapping(
            value = "/{id}",
            consumes = "application/json"
    )
    public ResponseEntity<?> createOrUpdateTodo(@RequestBody Todo todo, @PathVariable("id") Long id) {
        long userId = 1;
        User user = new User();
        user.setId(userId);
        todo.setUser(user);
        todo.setId(id);
        Todo todo1 = todoRepository.save(todo);
        return new ResponseEntity<>(todo1, HttpStatus.CREATED);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    public ResponseEntity<?> deleteTodo(@PathVariable("id") Long id) {
        todoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
