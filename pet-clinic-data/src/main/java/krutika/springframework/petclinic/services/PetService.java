package krutika.springframework.petclinic.services;

import krutika.springframework.petclinic.model.Pet;
import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/2/2020, Tue
 **/
public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
