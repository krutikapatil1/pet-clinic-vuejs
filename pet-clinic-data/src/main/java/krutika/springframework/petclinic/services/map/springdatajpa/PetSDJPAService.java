package krutika.springframework.petclinic.services.map.springdatajpa;

import krutika.springframework.petclinic.model.Pet;
import krutika.springframework.petclinic.model.PetType;
import krutika.springframework.petclinic.repositories.PetRepository;
import krutika.springframework.petclinic.repositories.PetTypeRepository;
import krutika.springframework.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : Krutika Patil
 * @since : 6/8/2020, Mon
 **/
@Service
@Profile("springdatajpa")
public class PetSDJPAService implements PetService {

    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public PetSDJPAService(PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        if (object.getId() != null) {
            Optional<Pet> petOptional = petRepository.findById(object.getId());
            if (petOptional.isPresent()) {
                object.setVisits(petOptional.get().getVisits());
            }
        }
        if (object.getPetType().getId() == null) {
            Iterable<PetType> petTypes = petTypeRepository.findAll();
            PetType petTypeRes = null;
            for (PetType petType : petTypes) {
                if (petType.getName().equalsIgnoreCase(object.getPetType().getName())) {
                    petTypeRes = petType;
                    break;
                }
            }
            object.setPetType(petTypeRes);
        }
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
