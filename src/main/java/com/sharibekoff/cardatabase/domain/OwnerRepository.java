package com.sharibekoff.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestController
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    List<Owner> findByFirstName(@Param("firstName") String firstName);
    List<Owner> findByLastName(@Param("lastName") String lastName);
}
