package com.flyingtechs.studentManagement.controller.impl;

import com.flyingtechs.studentManagement.dto.AttendanceRecordDTO;
import com.flyingtechs.studentManagement.model.AttendanceRecord;
import com.flyingtechs.studentManagement.service.AttendanceRecordService;
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
public class AttendanceRecordControllerImplTest1 {
    private static final String ENDPOINT_URL = "/attendance-records";

    @InjectMocks
    private AttendanceRecordControllerImpl attendancerecordController;

    @MockBean
    private AttendanceRecordService attendancerecordService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.attendancerecordController).build();
    }

    @Test
    public void getAll() throws Exception {
        AttendanceRecord record1 = new AttendanceRecord();
        record1.setId(1L);

        AttendanceRecord record2 = new AttendanceRecord();
        record2.setId(2L);

        Mockito.when(attendancerecordService.findAll()).thenReturn(Arrays.asList(record1, record2));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        AttendanceRecord record = new AttendanceRecord();
        record.setId(1L);

        Mockito.when(attendancerecordService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(record));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(attendancerecordService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(attendancerecordService);
    }

    @Test
    public void save() throws Exception {
        AttendanceRecord record = new AttendanceRecord();

        Mockito.when(attendancerecordService.save(ArgumentMatchers.any(AttendanceRecord.class))).thenReturn(record);

        mockMvc.perform(
                MockMvcRequestBuilders.post(ENDPOINT_URL)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(CustomUtils.asJsonString(new AttendanceRecordDTO(record)))
                        .accept((MediaType) MockMvcResultMatchers.status().isCreated()));
        Mockito.verify(attendancerecordService, Mockito.times(1)).save(ArgumentMatchers.any(AttendanceRecord.class));
        Mockito.verifyNoMoreInteractions(attendancerecordService);
    }

    @Test
    public void update() throws Exception {
        AttendanceRecord record = new AttendanceRecord();

        Mockito.when(attendancerecordService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(record);

        mockMvc.perform(
                MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(CustomUtils.asJsonString(new AttendanceRecordDTO(record)))
                        .accept((MediaType) MockMvcResultMatchers.status().isOk()));
        Mockito.verify(attendancerecordService, Mockito.times(1)).update(ArgumentMatchers.any(AttendanceRecord.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(attendancerecordService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(attendancerecordService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(attendancerecordService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(attendancerecordService);
    }
}