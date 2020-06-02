package krutika.springframework.petclinic.services;

import krutika.springframework.petclinic.model.Vet;

import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/2/2020, Tue
 **/
public interface VetService {
    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
