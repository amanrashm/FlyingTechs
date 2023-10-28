package com.flyingtechs.TestManagement.controller.impl;

import com.flyingtechs.TestManagement.dto.TestTypeDTO;
import com.flyingtechs.TestManagement.model.TestType;
import com.flyingtechs.TestManagement.service.TestTypeService;
import com.flyingtechs.userManagement.controller.impl.CustomUtils;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
public class TestTypeControllerImplTest {
    private static final String ENDPOINT_URL = "/test-types";

    @InjectMocks
    private TestTypeControllerImpl testTypeController;

    @Mock
    private TestTypeService testTypeService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.testTypeController).build();
    }

    @Test
    public void getAll() throws Exception {
        TestType testType1 = new TestType();
        testType1.setId(1L);

        TestType testType2 = new TestType();
        testType2.setId(2L);

        Mockito.when(testTypeService.findAll()).thenReturn(Arrays.asList(testType1, testType2));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
    }

    @Test
    public void getById() throws Exception {
        TestType testType = new TestType();
        testType.setId(1L);

        Mockito.when(testTypeService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(testType));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(testTypeService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(testTypeService);
    }

    @Test
    public void save() throws Exception {
        TestType testType = new TestType();

        Mockito.when(testTypeService.save(ArgumentMatchers.any(TestType.class))).thenReturn(testType);

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(new TestTypeDTO(testType)))
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(testTypeService, Mockito.times(1)).save(ArgumentMatchers.any(TestType.class));
        Mockito.verifyNoMoreInteractions(testTypeService);
    }

    @Test
    public void update() throws Exception {
        TestType testType = new TestType();

        Mockito.when(testTypeService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(testType);

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(new TestTypeDTO(testType)))
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(testTypeService, Mockito.times(1)).update(ArgumentMatchers.any(TestType.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(testTypeService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(testTypeService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(testTypeService, Mockito.times(1)).deleteById(ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(testTypeService);
    }
}