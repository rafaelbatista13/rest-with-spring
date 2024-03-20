package br.com.estudo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.estudo.entities.Person;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {

        logger.info("Finding all persons!");

        List<Person> persons = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            Person person = persons.get(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id) {

        logger.info("Finding a person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Rafael");
        person.setLastName("Batista");
        person.setAddress("Lapa - São Paulo - Brasil");
        person.setGender("Male");
        return person;
    }

    public Person creatingPerson(Person person) {

        logger.info("Creating person");

        return person;
    }

    public Person updatePerson(Person person) {

        logger.info("Person updated");

        return person;
    }

    public void deletePerson(String id) {

        logger.info("Person deleted");
    }

    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Gabriel");
        person.setLastName("Batista");
        person.setAddress("Osasco - São Paulo - Brasil");
        person.setGender("Male");
        return person;
    }

}
