package ru.netology.zlyden.DaoHibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.zlyden.DaoHibernate.domain.Person;

import java.util.List;


@Repository
public class PersonsRepository {
    @PersistenceContext
    EntityManager em;

    public List<Person> getPersonsByCity(String city) {
        List<Person> persons = em.createQuery("SELECT e FROM Person e").getResultList();
        List<Person> filteredPersons = persons.stream().filter(p -> p.getCityOfLeaving().toLowerCase().equals(city.toLowerCase())).toList();
        return filteredPersons;
    }
}
