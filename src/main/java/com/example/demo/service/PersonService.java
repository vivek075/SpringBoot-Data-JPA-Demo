package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Value("${com.example.demo.flag}")
    private boolean flag;

    @Transactional
    public Person savePerson(Person Person) {
        return personRepository.save(Person);
    }

    @Transactional(readOnly = true)
    public Person findPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Person> findAllPersons() {
        return (List<Person>) personRepository.findAll();
    }

    @Transactional
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Transactional
    public void transactionalMethodExample() {
        Person Person1 = new Person();
        Person1.setName("Person1");
        Person1.setEmail("Person1@example.com");
        personRepository.save(Person1);

        Person Person2 = new Person();
        Person2.setName("Person2");
        Person2.setEmail("Person2@example.com");
        personRepository.save(Person2);

        if (flag) {
            throw new RuntimeException("Rolling back transaction");
        }
    }
}
