package krutika.springframework.petclinic.controllers;

import krutika.springframework.petclinic.model.Owner;
import krutika.springframework.petclinic.model.Pet;
import krutika.springframework.petclinic.model.Visit;
import krutika.springframework.petclinic.services.PetService;
import krutika.springframework.petclinic.services.VisitService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Krutika Patil
 * @since : 6/19/2020, Fri
 **/
@RestController
@RequestMapping(value = "/visits")
public class VisitsController {
    private final VisitService visitService;
    private final PetService petService;

    public VisitsController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @PostMapping(value = "/addVisit/{petId}")
    public Owner addVisit(@PathVariable String petId, @RequestBody Visit visit) {
        Pet pet = petService.findById(Long.parseLong(petId));
        visit.setPet(pet);
        visitService.save(visit);
        return pet.getOwner();
    }
}
