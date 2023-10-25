package com.flyingtechs.HrManagement.controller.impl;

import com.flyingtechs.HrManagement.controller.HRController;
import com.flyingtechs.HrManagement.dto.HRDTO;
import com.flyingtechs.HrManagement.mapper.HRMapper;
import com.flyingtechs.HrManagement.model.HR;
import com.flyingtechs.HrManagement.service.HRService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/hR")
@RestController
public class HRControllerImpl implements HRController {
    private final HRService hRService;
    private final HRMapper hRMapper;

    public HRControllerImpl(HRService hRService, HRMapper hRMapper) {
        this.hRService = hRService;
        this.hRMapper = hRMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HRDTO save(@RequestBody HRDTO hRDTO) {
        HR hR = hRMapper.asEntity(hRDTO);
        return hRMapper.asDTO(hRService.save(hR));
    }

    @Override
    @GetMapping("/{id}")
    public HRDTO findById(@PathVariable("id") Long id) {
        HR hR = hRService.findById(id).orElse(null);
        return hRMapper.asDTO(hR);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        hRService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<HRDTO> list() {
        return hRMapper.asDTOList(hRService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<HRDTO> pageQuery(Pageable pageable) {
        Page<HR> hRPage = hRService.findAll(pageable);
        List<HRDTO> dtoList = hRPage
                .stream()
                .map(hRMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, hRPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public HRDTO update(@RequestBody HRDTO hRDTO, @PathVariable("id") Long id) {
        HR hR = hRMapper.asEntity(hRDTO);
        return hRMapper.asDTO(hRService.update(hR, id));
    }
}