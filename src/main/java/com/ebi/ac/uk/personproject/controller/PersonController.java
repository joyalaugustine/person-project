/*
 *  Copyright (c) 2020 EMBL-EBI.
 */

package com.ebi.ac.uk.personproject.controller;

import com.ebi.ac.uk.personproject.beans.PersonNotFoundException;
import com.ebi.ac.uk.personproject.beans.constants.APIMappingConstants;
import com.ebi.ac.uk.personproject.beans.dto.PersonDTO;
import com.ebi.ac.uk.personproject.beans.dto.PersonRequestDTO;
import com.ebi.ac.uk.personproject.beans.entity.PersonEntity;
import com.ebi.ac.uk.personproject.service.PersonService;
import com.ebi.ac.uk.personproject.util.PersonUtility;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static com.ebi.ac.uk.personproject.beans.constants.APIMappingConstants.PERSON_ID;

/**
 * Controller layer(Taking all the hits 😃)
 *
 * @author EMBL-EBI
 */
@RestController
@Validated
@Slf4j
@AllArgsConstructor
@RequestMapping(value = APIMappingConstants.VERSION1_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    private PersonService personService;

    @GetMapping("/persons")
    public List<PersonEntity> retrieveAllPersonEntries() {
        return personService.findAll();
    }

    @GetMapping("/persons/{id}")
    public PersonEntity retrievePersonEntry(@PathVariable long id) {

        log.info(PERSON_ID, id);
        Optional<PersonEntity> person = personService.retrievePersonEntry(id);

        if (!person.isPresent()) {
            throw new PersonNotFoundException("No Such user is found");
        }

        return person.get();
    }

    @DeleteMapping("/persons/{id}")
    public void deletePersonEntry(@PathVariable long id) {
        log.info(PERSON_ID, id);
        personService.deleteById(id);
    }

    @PostMapping("/persons")
    public ResponseEntity<Object> createPersonEntry(@RequestBody PersonRequestDTO person) {

        log.info("Person: {}", person);

        for (PersonDTO personDTO : person.getPersonDTOList()) {
            personService.save(PersonUtility.convert(personDTO));
        }

        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<PersonEntity> updatePersonEntry(@RequestBody PersonDTO person, @PathVariable long id) {

        log.info(PERSON_ID, id);
        Optional<PersonEntity> personOptional = personService.retrievePersonEntry(id);

        if (!personOptional.isPresent())
            return ResponseEntity.notFound().build();

        person.setId(id);

        personService.save(PersonUtility.convert(person));

        return ResponseEntity.noContent().build();
    }
}
