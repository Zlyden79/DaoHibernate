package ru.netology.zlyden.DaoHibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.zlyden.DaoHibernate.domain.Person;
import ru.netology.zlyden.DaoHibernate.service.PersonsService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonsController {
    private final PersonsService personsService;

    @Autowired
    public PersonsController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam(name = "city") String city) {
        return personsService.getPersonsByCity(city);
    }
}
