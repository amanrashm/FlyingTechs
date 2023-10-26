package com.flyingtechs.studentManagement.controller.impl;

import com.flyingtechs.studentManagement.dto.StudentDTO;
import com.flyingtechs.studentManagement.model.Student;
import com.flyingtechs.studentManagement.service.StudentService;
import com.flyingtechs.userManagement.controller.impl.CustomUtils;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(JUnit4.class)
public class StudentControllerImplTest {
    private static final String ENDPOINT_URL = "/students";

    @InjectMocks
    private StudentControllerImpl studentController;

    @MockBean
    private StudentService studentService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.studentController).build();
    }

    @Test
    public void getAll() throws Exception {
        Student student1 = new Student();
        student1.setId(1L);

        Student student2 = new Student();
        student2.setId(2L);

        Mockito.when(studentService.findAll()).thenReturn(Arrays.asList(student1, student2));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
    }

    @Test
    public void getById() throws Exception {
        Student student = new Student();
        student.setId(1L);

        Mockito.when(studentService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(student));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(studentService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(studentService);
    }

    @Test
    public void save() throws Exception {
        Student student = new Student();

        Mockito.when(studentService.save(ArgumentMatchers.any(Student.class))).thenReturn(student);

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(new StudentDTO(student)))
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(studentService, Mockito.times(1)).save(ArgumentMatchers.any(Student.class));
        Mockito.verifyNoMoreInteractions(studentService);
    }

    @Test
    public void update() throws Exception {
        Student student = new Student();

        Mockito.when(studentService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(student);

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(new StudentDTO(student)))
                                .accept(MediaType.APPLICATION_JSON))
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
        Mockito.verify(studentService, Mockito.times(1)).deleteById(ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(studentService);
    }
}