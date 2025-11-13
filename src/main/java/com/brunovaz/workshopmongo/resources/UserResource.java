package com.brunovaz.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunovaz.workshopmongo.domain.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> listAll(){
        User maria = new User("1","Maria Brown", "maria@gmail.com");
        User alex = new User("1", "Alex Green", "maria@gmail.com");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria,alex));
        return ResponseEntity.ok().body(list);
    }
}
