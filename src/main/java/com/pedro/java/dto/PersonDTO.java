package com.pedro.java.dto;


import com.pedro.java.Model.Person;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PersonDTO {
    private int id;
    private String nome;
    private Double idade;

    public PersonDTO (int id, String nome, Double idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }
    public PersonDTO (Person person) {
        this.id = person.getId ();
        this.nome = person.getNome ();
        this.idade = person.getIdade ();
    }

    public PersonDTO () {
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public Double getIdade () {
        return idade;
    }

    public void setIdade (Double idade) {
        this.idade = idade;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDTO personDTO)) return false;
        return id == personDTO.id && Objects.equals (nome, personDTO.nome) && Objects.equals (idade, personDTO.idade);
    }

    @Override
    public int hashCode () {
        return Objects.hash (id, nome, idade);
    }
    public static List<PersonDTO> convert(List<Person> person){
        return person.stream ().map (PersonDTO::new).collect(Collectors.toList());
    }
}
