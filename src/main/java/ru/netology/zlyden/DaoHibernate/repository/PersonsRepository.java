package ru.netology.zlyden.DaoHibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.zlyden.DaoHibernate.domain.Human;
import ru.netology.zlyden.DaoHibernate.domain.Person;

import java.util.List;


@Repository
public class PersonsRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void repositoryInit() {

        Human human1 = new Human().builder().name("alexey").surname("Bogomolov").age(44).build();
        Human human2 = new Human().builder().name("Alexey").surname("Orlov").age(45).build();
        Human human3 = new Human().builder().name("ALEXEY").surname("Mirin").age(44).build();
        Human human4 = new Human().builder().name("Vasiliy").surname("Stepanov").age(58).build();
        Human human5 = new Human().builder().name("Vasiliy").surname("Utkin").age(52).build();

        Person person1 = new Person().builder().human(human1).phoneNumber("+79173412345").cityOfLeaving("Ufa").build();
        em.persist(person1);
        Person person2 = new Person().builder().human(human2).phoneNumber("+79173412346").cityOfLeaving("Moscow").build();
        em.persist(person2);
        Person person3 = new Person().builder().human(human3).phoneNumber("+79173412347").cityOfLeaving("Moscow").build();
        em.persist(person3);
        Person person4 = new Person().builder().human(human4).phoneNumber("+79173412348").cityOfLeaving("Ufa").build();
        em.persist(person4);
        Person person5 = new Person().builder().human(human5).phoneNumber("+79173412349").cityOfLeaving("Moscow").build();
        em.persist(person5);

        System.out.println("repositoryInit done");
    }

    public List<Person> getPersonsByCity(String city) {
        List<Person> persons = em.createQuery("SELECT e FROM Person e").getResultList();
        List<Person> filteredPersons = persons.stream().filter(p -> p.getCityOfLeaving().toLowerCase().equals(city.toLowerCase())).toList();
        return filteredPersons;
    }
}
