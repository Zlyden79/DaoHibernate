package ru.netology.zlyden.DaoHibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.zlyden.DaoHibernate.domain.Human;
import ru.netology.zlyden.DaoHibernate.domain.Person;

import java.util.List;


@Repository
public interface PersonsRepository extends JpaRepository<Person, Human> {
    List<Person> findByCityOfLeaving(String city);
}
