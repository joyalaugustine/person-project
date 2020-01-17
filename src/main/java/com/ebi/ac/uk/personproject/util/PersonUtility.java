/*
 *  Copyright (c) 2020 EMBL-EBI.
 */

package com.ebi.ac.uk.personproject.util;

import com.ebi.ac.uk.personproject.beans.dto.PersonDTO;
import com.ebi.ac.uk.personproject.beans.entity.PersonEntity;

/**
 * Utility methods for person project.
 *
 * @author EMBL-EBI
 */
public class PersonUtility {

    /**
     * Private Constructor.
     */
    private PersonUtility() {
    }

    /**
     * Converts {@link PersonDTO} to {@link PersonEntity}
     */
    public static PersonEntity convert(PersonDTO personDTO) {
        return PersonEntity.builder()
                .id(personDTO.getId())
                .firstName(personDTO.getFirstName())
                .lastName(personDTO.getLastName())
                .age(personDTO.getAge())
                .favouriteColour(personDTO.getFavouriteColour())
                .hobbyList(personDTO.getHobbyList())
                .build();
    }
}
