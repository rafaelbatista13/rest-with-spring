package br.com.estudo.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.entities.Person;
import br.com.estudo.exceptions.ResourceNotFoundException;
import br.com.estudo.repositories.PersonRepository;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {

        logger.info("Finding all persons!");
        return repository.findAll();
    }

    public Person findById(Long id) {

        logger.info("Finding a person!");

        Person person = new Person();
        person.setFirstName("Rafael");
        person.setLastName("Batista");
        person.setAddress("Lapa - São Paulo - Brasil");
        person.setGender("Male");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id."));
    }

    public Person creatingPerson(Person person) {

        logger.info("Creating person");

        return repository.save(person);
    }

    public Person updatePerson(Person person) {

        logger.info("Person updated");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id."));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void deletePerson(Long id) {

        logger.info("Person deleted");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id."));
        repository.delete(entity);
    }

    // private Person mockPerson(int i) {

    // Person person = new Person();
    // person.setId(counter.incrementAndGet());
    // person.setFirstName("Gabriel");
    // person.setLastName("Batista");
    // person.setAddress("Osasco - São Paulo - Brasil");
    // person.setGender("Male");
    // return person;
    // }

}
