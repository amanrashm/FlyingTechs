package com.flyingtechs.studentManagement.controller.impl;

import com.flyingtechs.studentManagement.controller.impl.HomeworkSubmissionControllerImpl;
import com.flyingtechs.studentManagement.dto.HomeworkSubmissionDTO;
import com.flyingtechs.studentManagement.model.HomeworkSubmission;
import com.flyingtechs.studentManagement.service.HomeworkSubmissionService;
import com.flyingtechs.userManagement.controller.impl.CustomUtils;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
@RunWith(SpringRunner.class)
public class HomeworkSubmissionControllerImplTest1 {
    private static final String ENDPOINT_URL = "/homework-submissions";

    @InjectMocks
    private HomeworkSubmissionControllerImpl homeworkSubmissionController;

    @MockBean
    private HomeworkSubmissionService homeworkSubmissionService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.homeworkSubmissionController).build();
    }

    @Test
    public void getAll() throws Exception {
        HomeworkSubmission submission1 = new HomeworkSubmission();
        submission1.setId(1L);

        HomeworkSubmission submission2 = new HomeworkSubmission();
        submission2.setId(2L);

        Mockito.when(homeworkSubmissionService.findAll()).thenReturn(Arrays.asList(submission1, submission2));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        HomeworkSubmission submission = new HomeworkSubmission();
        submission.setId(1L);

        Mockito.when(homeworkSubmissionService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(submission));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(homeworkSubmissionService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(homeworkSubmissionService);
    }

    @Test
    public void save() throws Exception {
        HomeworkSubmission submission = new HomeworkSubmission();

        Mockito.when(homeworkSubmissionService.save(ArgumentMatchers.any(HomeworkSubmission.class))).thenReturn(submission);

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(new HomeworkSubmissionDTO(submission)))
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(homeworkSubmissionService, Mockito.times(1)).save(ArgumentMatchers.any(HomeworkSubmission.class));
        Mockito.verifyNoMoreInteractions(homeworkSubmissionService);
    }

    @Test
    public void update() throws Exception {
        HomeworkSubmission submission = new HomeworkSubmission();

        Mockito.when(homeworkSubmissionService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(submission);

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(new HomeworkSubmissionDTO(submission)))
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(homeworkSubmissionService, Mockito.times(1)).update(ArgumentMatchers.any(HomeworkSubmission.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(homeworkSubmissionService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(homeworkSubmissionService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(homeworkSubmissionService, Mockito.times(1)).deleteById(ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(homeworkSubmissionService);
    }
}