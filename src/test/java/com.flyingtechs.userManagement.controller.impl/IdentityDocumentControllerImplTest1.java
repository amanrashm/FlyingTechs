package com.flyingtechs.userManagement.controller.impl;

import com.flyingtechs.userManagement.dto.IdentityDocumentDTO;
import com.flyingtechs.userManagement.model.IdentityDocument;
import com.flyingtechs.userManagement.service.IdentityDocumentService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class IdentityDocumentControllerImplTest1 {
    private static final String ENDPOINT_URL = "/identity-documents";

    @InjectMocks
    private IdentityDocumentControllerImpl identityDocumentController;

    @MockBean
    private IdentityDocumentService identityDocumentService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.identityDocumentController).build();
    }

    @Test
    public void getAll() throws Exception {
        IdentityDocument identityDocument1 = new IdentityDocument();
        identityDocument1.setId(1L);

        IdentityDocument identityDocument2 = new IdentityDocument();
        identityDocument2.setId(2L);

        Mockito.when(identityDocumentService.findAll()).thenReturn(Arrays.asList(identityDocument1, identityDocument2));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
    }

    @Test
    public void getById() throws Exception {
        IdentityDocument identityDocument = new IdentityDocument();
        identityDocument.setId(1L);

        Mockito.when(identityDocumentService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(identityDocument));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(identityDocumentService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(identityDocumentService);
    }

    @Test
    public void save() throws Exception {
        IdentityDocument identityDocument = new IdentityDocument();

        Mockito.when(identityDocumentService.save(ArgumentMatchers.any(IdentityDocument.class))).thenReturn(identityDocument);

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(new IdentityDocumentDTO(identityDocument)))
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(identityDocumentService, Mockito.times(1)).save(ArgumentMatchers.any(IdentityDocument.class));
        Mockito.verifyNoMoreInteractions(identityDocumentService);
    }

    @Test
    public void update() throws Exception {
        IdentityDocument identityDocument = new IdentityDocument();

        Mockito.when(identityDocumentService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(identityDocument);

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(new IdentityDocumentDTO(identityDocument)))
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(identityDocumentService, Mockito.times(1)).update(ArgumentMatchers.any(IdentityDocument.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(identityDocumentService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(identityDocumentService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(identityDocumentService, Mockito.times(1)).deleteById(ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(identityDocumentService);
    }
}