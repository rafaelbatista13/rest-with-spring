package br.com.estudo.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.data.vo.v1.PersonVO;
import br.com.estudo.entities.Person;
import br.com.estudo.exceptions.ResourceNotFoundException;
import br.com.estudo.mapper.DozerMapper;
import br.com.estudo.repositories.PersonRepository;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll() {

        logger.info("Finding all persons!");
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {

        logger.info("Finding a person!");
        return DozerMapper.parseObject(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id.")), PersonVO.class);
    }

    public PersonVO creatingPerson(PersonVO person) {
        logger.info("Creating person");
        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

        return vo;
    }

    public PersonVO updatePerson(PersonVO person) {

        logger.info("Person updated");

        PersonVO entity = DozerMapper.parseObject(repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id.")), PersonVO.class);

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var pessoa = DozerMapper.parseObject(entity, Person.class);
        var vo = DozerMapper.parseObject(repository.save(pessoa), PersonVO.class);
        return vo;
    }

    public void deletePerson(Long id) {

        logger.info("Person deleted");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id."));

        repository.delete(entity);
    }

}
