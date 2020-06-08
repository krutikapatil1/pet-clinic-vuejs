package krutika.springframework.petclinic.repositories;

import krutika.springframework.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : Krutika Patil
 * @since : 6/8/2020, Mon
 **/
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
