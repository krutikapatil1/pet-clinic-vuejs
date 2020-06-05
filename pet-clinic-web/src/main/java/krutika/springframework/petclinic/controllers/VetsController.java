package krutika.springframework.petclinic.controllers;

import krutika.springframework.petclinic.model.Vet;
import krutika.springframework.petclinic.services.VetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/5/2020, Fri
 **/
@RestController
public class VetsController {

    private final VetService vetService;

    public VetsController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping(value = "/getVets", method = RequestMethod.GET)
    public Set<Vet> getVets() {
        return vetService.findAll();
    }
}
