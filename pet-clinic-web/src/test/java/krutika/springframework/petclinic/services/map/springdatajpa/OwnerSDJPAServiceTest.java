package krutika.springframework.petclinic.services.map.springdatajpa;

import krutika.springframework.petclinic.model.Owner;
import krutika.springframework.petclinic.repositories.OwnerRepository;
import krutika.springframework.petclinic.repositories.PetRepository;
import krutika.springframework.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author : Krutika Patil
 * @since : 6/11/2020, Thu
 **/
@ExtendWith(MockitoExtension.class)
class OwnerSDJPAServiceTest {

    public static final Long ID = 1L;
    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;
    @InjectMocks
    OwnerSDJPAService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(ID).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        Mockito.when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(returnOwner);
        Owner result = service.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, result.getLastName());
        Mockito.verify(ownerRepository, Mockito.times(1)).findByLastName(LAST_NAME);
    }

    @Test
    void findAllByLastNameLike() {
        List<Owner> owners = new ArrayList<>();
        owners.add(Owner.builder().id(1L).lastName(LAST_NAME).build());
        owners.add(Owner.builder().id(2L).lastName(LAST_NAME).build());
        Mockito.when(ownerRepository.findAllByLastNameLike(LAST_NAME)).thenReturn(owners);
        List<Owner> result = service.findAllByLastNameLike(LAST_NAME);
        assertEquals(LAST_NAME, result.get(0).getLastName());
        Mockito.verify(ownerRepository, Mockito.times(1)).findAllByLastNameLike(LAST_NAME);
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
        Mockito.when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> result = service.findAll();
        assertEquals(2, result.size());
        Mockito.verify(ownerRepository, Mockito.times(1)).findAll();
    }

    @Test
    void findById() {
        Mockito.when(ownerRepository.findById(Mockito.any())).thenReturn(Optional.of(returnOwner));
        assertEquals(1L, service.findById(returnOwner.getId()).getId());
        Mockito.verify(ownerRepository, Mockito.times(1)).findById(Mockito.any());
    }

    @Test
    void findByIdNotFound() {
        Mockito.when(ownerRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        assertNull(service.findById(returnOwner.getId()));
        Mockito.verify(ownerRepository, Mockito.times(1)).findById(Mockito.any());
    }

    @Test
    void save() {
        Owner savedOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
        Mockito.when(ownerRepository.save(savedOwner)).thenReturn(returnOwner);
        Owner result = service.save(savedOwner);
        assertEquals(LAST_NAME, result.getLastName());
        Mockito.verify(ownerRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        assertEquals(0, service.findAll().size());
        Mockito.verify(ownerRepository, Mockito.times(1)).delete(Mockito.any());
    }

    @Test
    void deleteById() {
        service.deleteById(returnOwner.getId());
        assertEquals(0, service.findAll().size());
        assertNull(service.findById(returnOwner.getId()));
        Mockito.verify(ownerRepository, Mockito.times(1)).deleteById(Mockito.any());
    }
}