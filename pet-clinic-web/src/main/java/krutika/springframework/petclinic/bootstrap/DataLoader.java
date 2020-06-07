package krutika.springframework.petclinic.bootstrap;

import krutika.springframework.petclinic.model.Owner;
import krutika.springframework.petclinic.model.Pet;
import krutika.springframework.petclinic.model.PetType;
import krutika.springframework.petclinic.model.Vet;
import krutika.springframework.petclinic.services.OwnerService;
import krutika.springframework.petclinic.services.PetService;
import krutika.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author : Krutika Patil
 * @since : 6/5/2020, Fri
 **/
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dogPetType = new PetType();
        dogPetType.setName("Dog");

        PetType catPetType = new PetType();
        catPetType.setName("Cat");

        Owner owner1 = new Owner();
        owner1.setFirstName("Sam");
        owner1.setLastName("Mendis");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1234567890");
        Pet samsPet = new Pet();
        samsPet.setPetType(dogPetType);
        samsPet.setName("Roccs");
        samsPet.setBirthDate(LocalDate.now());
        samsPet.setOwner(owner1);
        owner1.getPets().add(samsPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jon");
        owner2.setLastName("Faverou");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("9987654321");
        Pet jonsPet = new Pet();
        jonsPet.setPetType(catPetType);
        jonsPet.setName("Fiona");
        jonsPet.setBirthDate(LocalDate.now());
        jonsPet.setOwner(owner2);
        owner2.getPets().add(jonsPet);
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
