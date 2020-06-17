package krutika.springframework.petclinic.controllers;

import krutika.springframework.petclinic.model.Owner;
import krutika.springframework.petclinic.services.OwnerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/5/2020, Fri
 **/
@RestController
@RequestMapping(value = "/owners/")
public class OwnersController {

    private final OwnerService ownerService;

    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping(value = "findOwners")
    public Set<Owner> findOwners() {
        Set<Owner> owners = ownerService.findAll();
        return owners;
    }

    @GetMapping(value = "findOwnerById/{ownerId}")
    public Owner findOwnerById(@PathVariable String ownerId) {
        Owner owner = ownerService.findById(Long.parseLong(ownerId));
        return owner;
    }

    @GetMapping(value = "findAllByLastNameLike/{lastName}")
    public List<Owner> findAllByLastNameLike(@PathVariable String lastName) {
        List<Owner> owners = ownerService.findAllByLastNameLike('%' +lastName + '%');
        return owners;
    }
}
