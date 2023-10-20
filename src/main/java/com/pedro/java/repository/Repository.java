package com.pedro.java.repository;

import com.pedro.java.Model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<Person, Integer> {

    List<Person> findAll();
    Person findById(int id);

    List<Person> findByOrderByNomeDesc();

    List<Person> findByNomeContaining(String termo);

    @Query(value = "SELECT SUM(idade) FROM Persons", nativeQuery = true)
    int sumIdades();

    @Query(value = "SELECT * FROM Persons WHERE IDADE >= :idade", nativeQuery = true)
    List<Person> idadeMaiorIgual(int idade);

    int countById(int id);
}
