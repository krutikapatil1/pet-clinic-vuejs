package krutika.springframework.petclinic.bootstrap;

import krutika.springframework.petclinic.model.Owner;
import krutika.springframework.petclinic.model.Pet;
import krutika.springframework.petclinic.model.PetType;
import krutika.springframework.petclinic.model.Specialty;
import krutika.springframework.petclinic.model.Vet;
import krutika.springframework.petclinic.model.Visit;
import krutika.springframework.petclinic.services.OwnerService;
import krutika.springframework.petclinic.services.PetTypeService;
import krutika.springframework.petclinic.services.SpecialtyService;
import krutika.springframework.petclinic.services.VetService;
import krutika.springframework.petclinic.services.VisitService;
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
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dogPetType = new PetType();
        dogPetType.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dogPetType);

        PetType catPetType = new PetType();
        catPetType.setName("Cat");
        PetType savedCatPetType = petTypeService.save(catPetType);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Sam");
        owner1.setLastName("Mendis");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1234567890");
        Pet samsPet = new Pet();
        samsPet.setPetType(savedDogPetType);
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
        jonsPet.setPetType(savedCatPetType);
        jonsPet.setName("Fiona");
        jonsPet.setBirthDate(LocalDate.now());
        jonsPet.setOwner(owner2);
        owner2.getPets().add(jonsPet);
        ownerService.save(owner2);

        Visit visit1 = new Visit();
        visit1.setPet(samsPet);
        visit1.setDate(LocalDate.now());
        visit1.setDescription("Sneezy dog");
        Visit visit2 = new Visit();
        visit2.setPet(jonsPet);
        visit2.setDate(LocalDate.now());
        visit2.setDescription("Sleepy cat");
        visitService.save(visit1);
        visitService.save(visit2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("George");
        vet1.setLastName("Martin");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Samuels");
        vet2.setLastName("Michael");
        vet2.getSpecialties().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
