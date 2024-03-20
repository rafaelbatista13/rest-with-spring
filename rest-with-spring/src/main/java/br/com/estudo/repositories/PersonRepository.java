package br.com.estudo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudo.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
