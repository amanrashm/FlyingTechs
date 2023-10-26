package com.flyingtechs.studentManagement.controller.impl;

import com.flyingtechs.studentManagement.controller.AttendanceRecordController;
import com.flyingtechs.studentManagement.dto.AttendanceRecordDTO;
import com.flyingtechs.studentManagement.model.AttendanceRecord;
import com.flyingtechs.studentManagement.service.AttendanceRecordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/attendance-record")
@RestController
public class AttendanceRecordControllerImpl implements AttendanceRecordController {
    private final AttendanceRecordService attendanceRecordService;

    public AttendanceRecordControllerImpl(AttendanceRecordService attendanceRecordService) {
        this.attendanceRecordService = attendanceRecordService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AttendanceRecordDTO save(@RequestBody AttendanceRecordDTO attendanceRecordDTO) {
        AttendanceRecord attendanceRecord = attendanceRecordDTO.toEntity();
        return AttendanceRecordDTO.fromEntity(attendanceRecordService.save(attendanceRecord));
    }

    @Override
    @GetMapping("/{id}")
    public AttendanceRecordDTO findById(@PathVariable("id") Long id) {
        AttendanceRecord attendanceRecord = attendanceRecordService.findById(id).orElse(null);
        return AttendanceRecordDTO.fromEntity(attendanceRecord);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        attendanceRecordService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<AttendanceRecordDTO> list() {
        List<AttendanceRecord> attendanceRecords = attendanceRecordService.findAll();
        return attendanceRecords.stream().map(AttendanceRecordDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AttendanceRecordDTO> pageQuery(Pageable pageable) {
        Page<AttendanceRecord> attendanceRecordPage = attendanceRecordService.findAll(pageable);
        List<AttendanceRecordDTO> dtoList = attendanceRecordPage
                .getContent()
                .stream()
                .map(AttendanceRecordDTO::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, attendanceRecordPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AttendanceRecordDTO update(@RequestBody AttendanceRecordDTO attendanceRecordDTO, @PathVariable("id") Long id) {
        AttendanceRecord attendanceRecord = attendanceRecordDTO.toEntity();
        return AttendanceRecordDTO.fromEntity(attendanceRecordService.update(attendanceRecord, id));
    }
}