package krutika.springframework.petclinic.controllers;

import krutika.springframework.petclinic.model.Owner;
import krutika.springframework.petclinic.model.Pet;
import krutika.springframework.petclinic.services.OwnerService;
import krutika.springframework.petclinic.services.PetService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Krutika Patil
 * @since : 6/18/2020, Thu
 **/
@RestController
@RequestMapping(value = "/pets")
public class PetController {
    private final PetService petService;
    private final OwnerService ownerService;

    public PetController(PetService petService, OwnerService ownerService) {
        this.petService = petService;
        this.ownerService = ownerService;
    }

    @PostMapping(value = "/addPet/{ownerId}")
    public Owner addPet(@PathVariable String ownerId, @RequestBody Pet pet) {
        pet.setOwner(ownerService.findById(Long.parseLong(ownerId)));
        petService.save(pet);
        return ownerService.findById(Long.parseLong(ownerId));
    }

    @DeleteMapping(value = "/deletePet/{petId}")
    public Owner deletePet(@PathVariable String petId) {
        Pet pet = petService.findById(Long.parseLong(petId));
        Long ownerId = pet.getOwner().getId();
        petService.delete(pet);
        return ownerService.findById(ownerId);
    }
}
