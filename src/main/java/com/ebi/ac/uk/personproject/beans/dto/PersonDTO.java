/*
 *  Copyright (c) 2020 EMBL-EBI.
 */

package com.ebi.ac.uk.personproject.beans.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Person Data Transfer Object.
 *
 * @author EMBL-EBI
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotNull
    private int age;

    @NotEmpty
    private String favouriteColour;

    @JsonProperty("hobby")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> hobbyValues;
}
