package krutika.springframework.petclinic.services.map;

import krutika.springframework.petclinic.model.Pet;
import krutika.springframework.petclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/4/2020, Thu
 **/
@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public void delete(Pet object) {
        super.deleteByObject(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
