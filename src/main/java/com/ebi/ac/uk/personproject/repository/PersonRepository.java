package com.ebi.ac.uk.personproject.repository;

import com.ebi.ac.uk.personproject.beans.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
