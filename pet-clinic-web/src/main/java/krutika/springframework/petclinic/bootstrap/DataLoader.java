package krutika.springframework.petclinic.bootstrap;

import krutika.springframework.petclinic.model.Owner;
import krutika.springframework.petclinic.model.PetType;
import krutika.springframework.petclinic.model.Vet;
import krutika.springframework.petclinic.services.OwnerService;
import krutika.springframework.petclinic.services.PetTypeService;
import krutika.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author : Krutika Patil
 * @since : 6/5/2020, Fri
 **/
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }
    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Sam");
        owner1.setLastName("Mendis");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jon");
        owner2.setLastName("Faverou");
        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("George");
        vet1.setLastName("Martin");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Samuels");
        vet2.setLastName("Michael");
        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
