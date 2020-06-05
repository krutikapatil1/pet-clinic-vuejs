package krutika.springframework.petclinic.controllers;

import krutika.springframework.petclinic.model.Owner;
import krutika.springframework.petclinic.services.OwnerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/5/2020, Fri
 **/
@RestController
public class OwnersController {

    private final OwnerService ownerService;

    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping(value = "/getOwners", method = RequestMethod.GET)
    public Set<Owner> getOwners() {
        return ownerService.findAll();
    }
}
