	package com.pedro.java.Services;

import com.pedro.java.Model.Message;
import com.pedro.java.Model.Person;
import com.pedro.java.dto.PersonDTO;
import com.pedro.java.repository.Repository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Message message;
    @Autowired
    private Repository repository;

    public ResponseEntity<?> cadastrar(Person obj){
        if (obj.getNome ().equals ("")) {
            message.setMessage ("Name vazio");
            return new ResponseEntity<> (message, HttpStatus.BAD_REQUEST);
        } else if (obj.getIdade () < 0) {
            message.setMessage ("Idade inválida");
            return new ResponseEntity<> (message, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<> (repository.save (obj), HttpStatus.CREATED);
        }
    }
    public ResponseEntity<?> selection(){
        return new ResponseEntity<> (repository.findAll (), HttpStatus.OK);
    }

    public ResponseEntity<?> selectById(int id){
        if (repository.countById (id) == 0){
            message.setMessage("Não encontrado");
            return new ResponseEntity<> (message, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<> (HttpStatus.OK);
        }
    }
    public ResponseEntity<?> edit(Person obj){
        if (repository.countById (obj.getId ()) == 0){
            message.setMessage ("Não encontrado");
            return new ResponseEntity<> (message, HttpStatus.NOT_FOUND);
        } else if (obj.getNome ().equals ("")) {
            message.setMessage ("Nome não encontrado");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (obj.getIdade () < 0) {
            message.setMessage ("Não válido");
            return new ResponseEntity<> (message, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<> (repository.save (obj), HttpStatus.OK);
        }

    }

    public ResponseEntity<?> removed(int id){
        if (repository.countById (id) == 0){
            message.setMessage ("Não Encontrado");
            return new ResponseEntity<> (message, HttpStatus.NOT_FOUND);
        }else {
            Person obj = repository.findById (id);
            repository.delete (obj);
            message.setMessage ("Deletado");
            return new ResponseEntity<> (message, HttpStatus.OK);
        }
    }
}
