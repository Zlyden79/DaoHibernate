package ru.netology.zlyden.DaoHibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.netology.zlyden.DaoHibernate.domain.Human;
import ru.netology.zlyden.DaoHibernate.domain.Person;

import java.util.List;

@Repository
public interface PersonsRepository extends JpaRepository<Person, Human> {

    @Query(value = "SELECT * FROM persons WHERE LOWER(city_of_living) = ?1", nativeQuery = true)
    List<Person> findByCityOfLiving(String city);

    @Query(value = "SELECT * FROM persons WHERE age <= ?1 ORDER BY age", nativeQuery = true)
    List<Person> findByLessThanAgeOrderByAge(int age);

    @Query(value = "SELECT * FROM persons WHERE LOWER(name) =?1 AND LOWER(surname) =?2", nativeQuery = true)
    List<Person> findByNameAndSurname(String name, String surname);
}
