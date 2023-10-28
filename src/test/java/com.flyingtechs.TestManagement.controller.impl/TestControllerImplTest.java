package com.flyingtechs.TestManagement.controller.impl;

import com.flyingtechs.TestManagement.dto.TestDTO;
import com.flyingtechs.TestManagement.model.Test1;
import com.flyingtechs.TestManagement.service.TestService;
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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class TestControllerImplTest {
    private static final String ENDPOINT_URL = "/tests";

    @InjectMocks
    private TestControllerImpl testController;

    @Mock
    private TestService testService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.testController).build();
    }

    @Test
    public void getAll() throws Exception {
        Test1 test1 = new Test1();
        test1.setId(1L);

        Test1 test2 = new Test1();
        test2.setId(2L);

        Mockito.when(testService.findAll()).thenReturn(Arrays.asList(test1, test2));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
    }

    @Test
    public void getById() throws Exception {
        Test1 test = new Test1();
        test.setId(1L);

        Mockito.when(testService.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(test));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(testService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(testService);
    }

    @Test
    public void save() throws Exception {
        Test1 test = new Test1();

        Mockito.when(testService.save(ArgumentMatchers.any(Test1.class))).thenReturn(test);

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(new TestDTO(test)))
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(testService, Mockito.times(1)).save(ArgumentMatchers.any(Test1.class));
        Mockito.verifyNoMoreInteractions(testService);
    }

    @Test
    public void update() throws Exception {
        Test1 test = new Test1();

        Mockito.when(testService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(test);

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(new TestDTO(test)))
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(testService, Mockito.times(1)).update(ArgumentMatchers.any(Test1.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(testService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(testService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(testService, Mockito.times(1)).deleteById(ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(testService);
    }
}