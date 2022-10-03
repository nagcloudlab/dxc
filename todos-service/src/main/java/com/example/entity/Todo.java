package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.bson.types.ObjectId;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
//@Document(collection = "todos")
public class Todo {
//    @Id
//    private ObjectId id;
    private int id;
    private String title;
    private boolean completed;
    private TodoType type;
}
