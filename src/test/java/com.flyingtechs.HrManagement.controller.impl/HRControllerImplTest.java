package com.flyingtechs.HrManagement.controller.impl;

import com.flyingtechs.HrManagement.mapper.HRMapper;
import com.flyingtechs.HrManagement.model.HR;
import com.flyingtechs.HrManagement.service.HRService;
import com.flyingtechs.studentManagement.controller.impl.CustomUtils;
import com.flyingtechs.studentManagement.mapper.ReferenceMapper;
import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
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

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(JUnit4..class)
public class HRControllerImplTest {
    //TODO: create the data Test generator class HRBuilder
    private static final String ENDPOINT_URL = "/hRs";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private HRControllerImpl hrController;
    @MockBean
    private HRService hrService;
    @MockBean
    private HRMapper hrMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before("")
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.hrController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(hrMapper.asDTOList(ArgumentMatchers.any())).thenReturn(HRBuilder.getListDTO());

        Mockito.when(hrService.findAll()).thenReturn(HRBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(hrMapper.asDTO(ArgumentMatchers.any())).thenReturn(HRBuilder.getDTO());

        Mockito.when(hrService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(HRBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(hrService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(hrService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(hrMapper.asEntity(ArgumentMatchers.any())).thenReturn(HRBuilder.getEntity());
        Mockito.when(hrService.save(ArgumentMatchers.any(HR.class))).thenReturn(HRBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(HRBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(hrService, Mockito.times(1)).save(ArgumentMatchers.any(HR.class));
        Mockito.verifyNoMoreInteractions(hrService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(hrMapper.asEntity(ArgumentMatchers.any())).thenReturn(HRBuilder.getEntity());
        Mockito.when(hrService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(HRBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(HRBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(hrService, Mockito.times(1)).update(ArgumentMatchers.any(HR.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(hrService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(hrService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(hrService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(hrService);
    }