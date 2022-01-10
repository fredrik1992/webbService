package com.example.personsrest;

import com.example.personsrest.domain.Person;
import com.example.personsrest.domain.PersonRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.*;
public class PersonRepositoryImpl implements PersonRepository {
    Map<String,PersonImpl> personList = new HashMap<String,PersonImpl>();


    @Override
    public Optional<Person> findById(String id) {

        return Optional.of(personList.get(id));
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(personList.values());
    }

    @Override
    public Page<Person> findAllByNameContainingOrCityContaining(String name, String city, Pageable pageable) {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Person save(Person person) {
        personList.put(person.getId(),personDTO(person));
        return personList.get(person.getId());
    }



    @Override
    public void delete(String id) {

    }
    public PersonImpl personDTO(Person person){
        PersonImpl personDTO= new PersonImpl(null,person.getName(),person.getCity(),person.getAge());
        personDTO.setName(person.getName());
        personDTO.setAge(person.getAge());
        personDTO.setCity(person.getCity());
        return personDTO;
    }
}
