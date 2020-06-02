package krutika.springframework.petclinic.services;

import krutika.springframework.petclinic.model.Owner;
import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/2/2020, Tue
 **/
public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
