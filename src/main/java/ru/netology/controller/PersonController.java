package ru.netology.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.entity.Person;
import ru.netology.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personRepository.getPersonsByCity(city);
    }
}
