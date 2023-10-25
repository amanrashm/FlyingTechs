package com.flyingtechs.studentManagement.controller.impl;

import com.flyingtechs.studentManagement.controller.impl.CustomUtils;
import com.flyingtechs.studentManagement.controller.impl.StudentControllerImpl;
import com.flyingtechs.studentManagement.dto.StudentDTO;
import com.flyingtechs.studentManagement.mapper.ReferenceMapper;
import com.flyingtechs.studentManagement.mapper.StudentMapper;
import com.flyingtechs.studentManagement.model.Student;
import com.flyingtechs.studentManagement.service.StudentService;
import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(JUnit4..class)
public class StudentControllerImplTest {
    //TODO: create the data Test generator class StudentBuilder
    private static final String ENDPOINT_URL = "/students";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private StudentControllerImpl studentController;
    @MockBean
    private StudentService studentService;
    @MockBean
    private StudentMapper studentMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before("")
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.studentController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(studentMapper.asDTOList(ArgumentMatchers.any())).thenReturn(StudentBuilder.getListDTO());

        Mockito.when(studentService.findAll()).thenReturn(StudentBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(studentMapper.asDTO(ArgumentMatchers.any())).thenReturn(StudentBuilder.getDTO());

        Mockito.when(studentService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(StudentBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(studentService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(studentService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(studentMapper.asEntity(ArgumentMatchers.any())).thenReturn(StudentBuilder.getEntity());
        Mockito.when(studentService.save(ArgumentMatchers.any(Student.class))).thenReturn(StudentBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(StudentBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(studentService, Mockito.times(1)).save(ArgumentMatchers.any(Student.class));
        Mockito.verifyNoMoreInteractions(studentService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(studentMapper.asEntity(ArgumentMatchers.any())).thenReturn(StudentBuilder.getEntity());
        Mockito.when(studentService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(StudentBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(StudentBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(studentService, Mockito.times(1)).update(ArgumentMatchers.any(Student.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(studentService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(studentService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(studentService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(studentService);
    }