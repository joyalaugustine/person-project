/*
 *  Copyright (c) 2020 EMBL-EBI.
 */

package com.ebi.ac.uk.personproject.service;

import com.ebi.ac.uk.personproject.beans.entity.PersonEntity;
import com.ebi.ac.uk.personproject.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Test class of PersonService.
 */
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    /**
     * Service class.
     */
    private PersonService service;

    /**
     * PersonRepository mock.
     */
    @Mock
    private PersonRepository repository;

    @BeforeEach
    public void init() {
        service = new PersonService(repository);
    }

    /**
     * Test of method save when input contains comma separated hobbies.
     */
    @Test
    void testSave() {
        ArgumentCaptor<PersonEntity> argumentCaptor = ArgumentCaptor.forClass(PersonEntity.class);
        PersonEntity personEntity = PersonEntity.builder()
                .favouriteColour("Yellow")
                .age(29)
                .firstName("Joyal")
                .lastName("Augustine")
                .hobbyList(Collections.singletonList("formula one, tennis"))
                .build();
        when(repository.save(argumentCaptor.capture())).thenReturn(personEntity);

        service.save(personEntity);

        PersonEntity captorValue = argumentCaptor.getValue();

        assertEquals(2, captorValue.getHobbyList().size());
        assertEquals("formula one", captorValue.getHobbyList().get(0));
        assertEquals("tennis", captorValue.getHobbyList().get(1));

    }

    /**
     * Test of method save when input does not contain comma separated hobbies.
     */
    @Test
    void testSaveNormalCase() {
        ArgumentCaptor<PersonEntity> argumentCaptor = ArgumentCaptor.forClass(PersonEntity.class);
        PersonEntity personEntity = PersonEntity.builder()
                .favouriteColour("Yellow")
                .age(29)
                .firstName("Joyal")
                .lastName("Augustine")
                .hobbyList(Arrays.asList("formula one", "tennis"))
                .build();
        when(repository.save(argumentCaptor.capture())).thenReturn(personEntity);

        service.save(personEntity);

        PersonEntity captorValue = argumentCaptor.getValue();

        assertEquals(2, captorValue.getHobbyList().size());
        assertEquals("formula one", captorValue.getHobbyList().get(0));
        assertEquals("tennis", captorValue.getHobbyList().get(1));

    }
}