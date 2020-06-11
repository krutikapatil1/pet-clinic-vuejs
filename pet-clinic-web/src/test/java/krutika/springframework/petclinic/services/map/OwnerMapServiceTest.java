package krutika.springframework.petclinic.services.map;

import krutika.springframework.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author : Krutika Patil
 * @since : 6/10/2020, Wed
 **/
class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    Long ownerId = 1L;
    String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Owner owner2 = Owner.builder().id(2L).build();
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(2L, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner owner = Owner.builder().build();
        Owner savedOwner = ownerMapService.save(owner);
        assertEquals(2L, savedOwner.getId());
        Owner owner4 = Owner.builder().build();
        Owner savedOwner1 = ownerMapService.save(owner4);
        assertEquals(3L, savedOwner1.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName_Success() {
        Owner owner = ownerMapService.findByLastName(lastName);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName_NotFound() {
        String lastName = "Foobar";
        Owner owner = ownerMapService.findByLastName(lastName);
        assertNull(owner);
    }
}