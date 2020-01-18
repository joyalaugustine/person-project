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
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Service layer(At your service 😃)
 *
 * @author EMBL-EBI
 */
@Service
@AllArgsConstructor
public class PersonService {

    //Array delimiter
    private static final String COMMA = ",";

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
        generateHobbyListFromString(personEntity).ifPresent(personEntity::setHobbyList);
        return personRepository.save(personEntity);
    }

    /**
     * Converts comma separated hobbies string to List of hobbies.
     *
     * @param personEntity Person Entity
     * @return Hobby List.
     */
    private Optional<List<String>> generateHobbyListFromString(PersonEntity personEntity) {
        List<String> hobbyList = personEntity.getHobbyList();
        if (hobbyList != null && hobbyList.size() == 1) {
            String hobby = hobbyList.get(0);
            if (hobby.contains(COMMA)) {
                return Optional.of(Stream.of(hobby.split(COMMA))
                        .map(String::trim)
                        .collect(Collectors.toList()));
            }
        }
        return Optional.empty();
    }
}