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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

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

        mockMvc.perform(get("/findOwners"))
                .andExpect(status().isOk());
        verify(ownerService, times(1)).findAll();
    }

    @Test
    void findOwnersNotFound() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is4xxClientError());
        verifyZeroInteractions(ownerService);
    }
}