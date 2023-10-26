package com.flyingtechs.teacherManagement.controller.impl;

import com.flyingtechs.teacherManagement.dto.TeacherDTO;
import com.flyingtechs.teacherManagement.model.Teacher;
import com.flyingtechs.teacherManagement.service.TeacherService;
import com.flyingtechs.userManagement.controller.impl.CustomUtils;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
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
public class TeacherControllerImplTest {
    private static final String ENDPOINT_URL = "/teachers";

    @InjectMocks
    private TeacherControllerImpl teacherController;

    @MockBean
    private TeacherService teacherService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.teacherController).build();
    }

    @Test
    public void getAll() throws Exception {
        Teacher teacher1 = new Teacher();
        teacher1.setId(1L);

        Teacher teacher2 = new Teacher();
        teacher2.setId(2L);

        Mockito.when(teacherService.findAll()).thenReturn(Arrays.asList(teacher1, teacher2));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
    }

    @Test
    public void getById() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setId(1L);

        Mockito.when(teacherService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(teacher));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(teacherService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(teacherService);
    }

    @Test
    public void save() throws Exception {
        Teacher teacher = new Teacher();

        Mockito.when(teacherService.save(ArgumentMatchers.any(Teacher.class))).thenReturn(teacher);

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(new TeacherDTO(teacher)))
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(teacherService, Mockito.times(1)).save(ArgumentMatchers.any(Teacher.class));
        Mockito.verifyNoMoreInteractions(teacherService);
    }

    @Test
    public void update() throws Exception {
        Teacher teacher = new Teacher();

        Mockito.when(teacherService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(teacher);

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(new TeacherDTO(teacher)))
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(teacherService, Mockito.times(1)).update(ArgumentMatchers.any(Teacher.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(teacherService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(teacherService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(teacherService, Mockito.times(1)).deleteById(ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(teacherService);
    }
}