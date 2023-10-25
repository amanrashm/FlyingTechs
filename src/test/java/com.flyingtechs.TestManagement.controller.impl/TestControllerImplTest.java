package com.flyingtechs.TestManagement.controller.impl;

import com.flyingtechs.TestManagement.mapper.TestMapper;
/*import com.flyingtechs.TestManagement.model.Test;*/
import com.flyingtechs.TestManagement.service.TestService;
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
@RunWith(JUnit4.class)
public class TestControllerImplTest {
    //TODO: create the data Test generator class TestBuilder
    private static final String ENDPOINT_URL = "/tests";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private TestControllerImpl testController;
    @MockBean
    private TestService testService;
    @MockBean
    private TestMapper testMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before("")
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.testController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(testMapper.asDTOList(ArgumentMatchers.any())).thenReturn(TestBuilder.getListDTO());

        Mockito.when(testService.findAll()).thenReturn(TestBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(testMapper.asDTO(ArgumentMatchers.any())).thenReturn(TestBuilder.getDTO());

        Mockito.when(testService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(TestBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(testService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(testService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(testMapper.asEntity(ArgumentMatchers.any())).thenReturn(TestBuilder.getEntity());
        Mockito.when(testService.save((com.flyingtechs.TestManagement.model.Test) ArgumentMatchers.any(Test.class))).thenReturn(TestBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(TestBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(testService, Mockito.times(1)).save((com.flyingtechs.TestManagement.model.Test) ArgumentMatchers.any(Test.class));
        Mockito.verifyNoMoreInteractions(testService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(testMapper.asEntity(ArgumentMatchers.any())).thenReturn(TestBuilder.getEntity());
        Mockito.when(testService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(TestBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(TestBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(testService, Mockito.times(1)).update((com.flyingtechs.TestManagement.model.Test) ArgumentMatchers.any(Test.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(testService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(testService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(testService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(testService);
    }