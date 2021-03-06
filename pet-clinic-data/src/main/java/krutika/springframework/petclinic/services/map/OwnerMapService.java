package krutika.springframework.petclinic.services.map;

import krutika.springframework.petclinic.model.Owner;
import krutika.springframework.petclinic.model.Pet;
import krutika.springframework.petclinic.services.OwnerService;
import krutika.springframework.petclinic.services.PetService;
import krutika.springframework.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/4/2020, Thu
 **/
@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private PetTypeService petTypeService;
    private PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets() != null) {
                if (object.getPets().size() != 0) {
                    object.getPets().forEach(pet -> {
                        if (pet.getPetType() != null) {
                            if (pet.getPetType().getId() == null) {
                                pet.setPetType(petTypeService.save(pet.getPetType()));
                            }
                        } else {
                            throw new RuntimeException("PetType is required");
                        }

                        if (pet.getId() == null) {
                            Pet savedPet = petService.save(pet);
                            savedPet.setId(savedPet.getId());
                        }
                    });
                }
            }
            return super.save(object);
        }
        else {
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.deleteByObject(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll().stream().filter(owner -> owner.getLastName().equalsIgnoreCase(lastName)).findFirst().orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        List<Owner> owners = new ArrayList<>();
        this.findAll().forEach(owner -> {
            if (owner.getLastName().toLowerCase().contains(lastName.toLowerCase())) {
               owners.add(owner);
            }
        });
        return owners.size() == 0 ? null : owners;
    }
}
