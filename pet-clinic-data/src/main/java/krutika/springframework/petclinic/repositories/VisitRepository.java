package krutika.springframework.petclinic.repositories;

import krutika.springframework.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : Krutika Patil
 * @since : 6/8/2020, Mon
 **/
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
