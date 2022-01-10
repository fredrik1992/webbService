package com.example.personsrest;

import com.example.personsrest.domain.Person;

import com.example.personsrest.domain.PersonRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PersonService {
   PersonRepository personRepository;
    //needs to create a person entity
    public Optional<Person> getById(String id){

        return personRepository.findById(id);
    }

    public ResponseEntity<Person> createPerson(String name, String city, int age) {
        String corrId = UUID.randomUUID().toString();
        Person person = new PersonImpl(corrId,name,city,age);
        System.out.println(person.getId());





        return ResponseEntity.ok(personRepository.save(person));
    }


    public ResponseEntity<List<Person>> all() {
        return ResponseEntity.ok(personRepository.findAll());
    }

    public Person update(String id, String name, String city, int age) {
        Person updatedPerson = new PersonImpl(id,name,city,age);
        System.out.println(updatedPerson.getId());
        System.out.println(personRepository.save(updatedPerson).getName());
        return updatedPerson;
    }
}
