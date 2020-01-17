/*
 *  Copyright (c) 2020 EMBL-EBI.
 */

package com.ebi.ac.uk.personproject.service;

import com.ebi.ac.uk.personproject.beans.entity.PersonEntity;
import com.ebi.ac.uk.personproject.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer(At your service 😃)
 *
 * @author EMBL-EBI
 */
@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;

    public List<PersonEntity> findAll() {
        return personRepository.findAll();
    }

    public Optional<PersonEntity> retrievePersonEntry(long id) {
        return personRepository.findById(id);
    }

    public void deleteById(long id) {
        personRepository.deleteById(id);
    }

    public PersonEntity save(PersonEntity personEntity) {
        return personRepository.save(personEntity);
    }
}