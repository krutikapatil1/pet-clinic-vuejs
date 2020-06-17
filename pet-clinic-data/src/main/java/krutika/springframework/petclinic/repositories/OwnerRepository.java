package krutika.springframework.petclinic.repositories;

import krutika.springframework.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author : Krutika Patil
 * @since : 6/8/2020, Mon
 **/
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
