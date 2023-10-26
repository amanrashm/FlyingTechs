package com.flyingtechs.userManagement.controller.impl;

import com.flyingtechs.userManagement.dto.AddressDTO;
import com.flyingtechs.userManagement.model.Address;
import com.flyingtechs.userManagement.service.AddressService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(JUnit4.class)
public class AddressControllerImplTest1 {
    private static final String ENDPOINT_URL = "/addresss";

    @InjectMocks
    private AddressControllerImpl addressController;

    @MockBean
    private AddressService addressService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.addressController).build();
    }

    @Test
    public void getAll() throws Exception {
        Address address1 = new Address();
        address1.setId(1L);

        Address address2 = new Address();
        address2.setId(2L);

        Mockito.when(addressService.findAll()).thenReturn(Arrays.asList(address1, address2));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Address address = new Address();
        address.setId(1L);

        Mockito.when(addressService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(address));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(addressService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(addressService);
    }

    @Test
    public void save() throws Exception {
        Address address = new Address();

        Mockito.when(addressService.save(ArgumentMatchers.any(Address.class))).thenReturn(address);

        mockMvc.perform(
                MockMvcRequestBuilders.post(ENDPOINT_URL)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(CustomUtils.asJsonString(new AddressDTO(address)))
                        .accept((MediaType) MockMvcResultMatchers.status().isCreated()));
        Mockito.verify(addressService, Mockito.times(1)).save(ArgumentMatchers.any(Address.class));
        Mockito.verifyNoMoreInteractions(addressService);
    }

    @Test
    public void update() throws Exception {
        Address address = new Address();

        Mockito.when(addressService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(address);

        mockMvc.perform(
                MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(CustomUtils.asJsonString(new AddressDTO(address)))
                        .accept((MediaType) MockMvcResultMatchers.status().isOk()));
        Mockito.verify(addressService, Mockito.times(1)).update(ArgumentMatchers.any(Address.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(addressService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(addressService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(addressService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(addressService);
    }
}