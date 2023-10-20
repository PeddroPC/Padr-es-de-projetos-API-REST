package com.pedro.java.Controllers;

import com.pedro.java.Model.Person;
import com.pedro.java.Services.Service;
import com.pedro.java.dto.PersonDTO;
import com.pedro.java.repository.Repository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryConfigurationSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private Repository repository;
    @Autowired
    private Service service;

    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody Person obj){
        return service.cadastrar(obj);
    }

    @GetMapping("/api")
    public ResponseEntity<?> selection(){
        return new ResponseEntity<> (service.selection (), HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<PersonDTO> lista(){
        List<Person> person = repository.findAll ();
        return PersonDTO.convert (person);
    }
    @GetMapping("/api/{id}")
    public ResponseEntity<?> selectById(@PathVariable int id){
        return service.selectById (id);
    }
    @PutMapping("/api")
    public ResponseEntity<?> edit(@RequestBody Person obj){
        return service.edit (obj);
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<?> removed(@PathVariable int id){
        return service.removed (id);
    }

    @GetMapping("/api/count")
    public long count(){
        return repository.count ();
    }

    @GetMapping("/api/ordername")
    public List<Person> orderName(){
        return repository.findByOrderByNomeDesc ();
    }

    @GetMapping("/api/NameContem/{termo}")
    public List<Person> NameContem(@PathVariable String termo){
        return repository.findByNomeContaining (termo);
    }
    @GetMapping("/api/sumIdades")
    public int sumIdades(){
        return repository.sumIdades ();
    }

    @GetMapping("/api/idadeMaiorIgual/{idade}")
    public List<Person> idadeMaiorIgual(@PathVariable int idade){
        return repository.idadeMaiorIgual (idade);
    }
    @GetMapping("/api/status")
    public ResponseEntity<?> status(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/pessoa")
    public Person person(@RequestBody Person p){
        return p;
    }
}