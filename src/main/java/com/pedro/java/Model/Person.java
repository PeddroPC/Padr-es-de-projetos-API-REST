package com.pedro.java.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private Double idade;

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
}
