package krutika.springframework.petclinic.controllers;

import krutika.springframework.petclinic.model.Owner;
import krutika.springframework.petclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author : Krutika Patil
 * @since : 6/11/2020, Thu
 **/
@ExtendWith(MockitoExtension.class)
class OwnersControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnersController controller;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void findOwners() throws Exception {
        Mockito.when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(get("/owners/findOwners"))
                .andExpect(status().isOk());
        verify(ownerService, times(1)).findAll();
    }

    @Test
    void findOwnersNotFound() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is4xxClientError());
        verifyZeroInteractions(ownerService);
    }

    @Test
    void findOwnerById() throws Exception {
        Owner owner = Owner.builder().id(1L).build();
        Mockito.when(ownerService.findById(anyLong())).thenReturn(owner);
        mockMvc.perform(get("/owners/findOwnerById/" + anyLong()))
                .andExpect(status().isOk());

        verify(ownerService, times(1)).findById(anyLong());
    }

    @Test
    void findAllByLastNameLike() throws Exception {
        List<Owner> owners = new ArrayList<>();
        owners.add(Owner.builder().id(1L).lastName("Smith").build());
        owners.add(Owner.builder().id(2L).lastName("Smith").build());
        mockMvc.perform(get("/owners/findAllByLastNameLike/Smit"))
                .andExpect(status().isOk());

        verify(ownerService, times(1)).findAllByLastNameLike(anyString());
        Mockito.when(ownerService.findAllByLastNameLike(anyString())).thenReturn(owners);
        List<Owner> result = controller.findAllByLastNameLike("%Smit%");
        assertEquals(2, result.size());
    }
}