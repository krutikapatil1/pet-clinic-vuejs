package krutika.springframework.petclinic.repositories;

import krutika.springframework.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : Krutika Patil
 * @since : 6/8/2020, Mon
 **/
public interface OwnerRespository extends CrudRepository<Owner, Long> {
}
