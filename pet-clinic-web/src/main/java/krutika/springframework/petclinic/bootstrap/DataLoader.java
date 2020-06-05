package krutika.springframework.petclinic.bootstrap;

import krutika.springframework.petclinic.model.Owner;
import krutika.springframework.petclinic.model.Vet;
import krutika.springframework.petclinic.services.OwnerService;
import krutika.springframework.petclinic.services.VetService;
import krutika.springframework.petclinic.services.map.OwnerServiceMap;
import krutika.springframework.petclinic.services.map.VetServiceMap;
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

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Sam");
        owner1.setLastName("Mendis");
        ownerService.save(owner1);

        owner1.setId(2L);
        owner1.setFirstName("Jon");
        owner1.setLastName("Faverou");
        ownerService.save(owner1);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("George");
        vet1.setLastName("Martin");
        vetService.save(vet1);

        vet1.setId(2L);
        vet1.setFirstName("Samuels");
        vet1.setLastName("Michael");
        vetService.save(vet1);

        System.out.println("Loaded Vets....");
    }
}
