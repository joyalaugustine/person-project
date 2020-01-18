/*
 *  Copyright (c) 2020 EMBL-EBI.
 */

package com.ebi.ac.uk.personproject.beans.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

/**
 * Person Wrapper Data Transfer Object.
 *
 * @author EMBL-EBI
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonRequestDTO {

    @JsonProperty("person")
    @Valid
    private List<PersonDTO> personDTOList;
}
