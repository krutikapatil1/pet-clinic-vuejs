package krutika.springframework.petclinic.services;

import krutika.springframework.petclinic.model.Owner;
import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/2/2020, Tue
 **/
public interface OwnerService extends BaseService<Owner, Long> {

    Owner findByLastName(String lastName);
}
