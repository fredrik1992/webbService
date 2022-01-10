package com.example.personsrest;

import com.example.personsrest.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    @Autowired PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> person (@PathVariable String id){
        System.out.println("test");
        System.out.println(id);

        return ResponseEntity.ok(personService.getById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Person>> getAll(){

        return personService.all();
    }
    @PostMapping("")
    public ResponseEntity<Person> add  (@RequestBody CreatePerson createPerson) throws JsonProcessingException {

        return  personService.createPerson(createPerson.getName(), createPerson.getCity(), createPerson.getAge());

    }

    @PutMapping("/{id}")
    public ResponseEntity <Person> update(@RequestBody CreatePerson createPerson){
        System.out.println(createPerson.getAge());
        return ResponseEntity.ok(personService.update(createPerson.getId(),createPerson.getName(),createPerson.getCity(),createPerson.getAge()));

    }

    @Value
    static class CreatePerson {
        String id;
        String name;
        String city;
        int age;
    }
}


