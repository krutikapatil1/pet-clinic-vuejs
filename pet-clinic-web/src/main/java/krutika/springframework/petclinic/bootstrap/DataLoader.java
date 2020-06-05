package krutika.springframework.petclinic.bootstrap;

import krutika.springframework.petclinic.model.Owner;
import krutika.springframework.petclinic.model.Vet;
import krutika.springframework.petclinic.services.OwnerService;
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

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Sam");
        owner1.setLastName("Mendis");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Jon");
        owner2.setLastName("Faverou");
        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("George");
        vet1.setLastName("Martin");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Samuels");
        vet2.setLastName("Michael");
        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
