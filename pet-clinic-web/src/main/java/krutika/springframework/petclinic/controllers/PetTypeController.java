package krutika.springframework.petclinic.controllers;

import krutika.springframework.petclinic.model.PetType;
import krutika.springframework.petclinic.services.PetTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/18/2020, Thu
 **/
@RestController
@RequestMapping(value = "petTypes/")
public class PetTypeController {

    private final PetTypeService petTypeService;

    public PetTypeController(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @GetMapping(value = "getAll")
    public List<String> getPetTypes() {
        Set<PetType> petTypes = petTypeService.findAll();
        List<String> petTypeList = new ArrayList<>();
        petTypes.forEach(petType -> petTypeList.add(petType.getName()));
        return petTypeList;
    }
}
