package br.com.estudo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.data.vo.v1.PersonVO;
import br.com.estudo.services.PersonServices;

@RestController
@RequestMapping(path = "/person")

public class PersonController {

    @Autowired
    private PersonServices service;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findAll() {
        return service.findAll();
    }

    @PostMapping(path = "/createPerson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO createPerson(@RequestBody PersonVO person) {
        return service.creatingPerson(person);
    }

    @PutMapping(path = "/updatePerson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO updatePerson(@RequestBody PersonVO person) {
        return service.updatePerson(person);
    }

    @DeleteMapping(path = "/deletePerson/{id}")
    public ResponseEntity<PersonVO> delete(@PathVariable(value = "id") Long id) {
        service.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

}