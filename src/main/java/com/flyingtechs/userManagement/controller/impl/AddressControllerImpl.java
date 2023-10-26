package com.flyingtechs.userManagement.controller.impl;

import com.flyingtechs.userManagement.controller.AddressController;
import com.flyingtechs.userManagement.dto.AddressDTO;
import com.flyingtechs.userManagement.model.Address;
import com.flyingtechs.userManagement.service.AddressService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/address")
@RestController
public class AddressControllerImpl implements AddressController {
    private final AddressService addressService;

    public AddressControllerImpl(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDTO save(@RequestBody AddressDTO addressDTO) {
        Address address = addressDTO.toEntity();
        return AddressDTO.fromEntity(addressService.save(address));
    }

    @Override
    @GetMapping("/{id}")
    public AddressDTO findById(@PathVariable("id") Long id) {
        Address address = addressService.findById(id).orElse(null);
        return AddressDTO.fromEntity(address);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        addressService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<AddressDTO> list() {
        List<Address> addresses = addressService.findAll();
        return addresses.stream().map(AddressDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AddressDTO> pageQuery(Pageable pageable) {
        Page<Address> addressPage = addressService.findAll(pageable);
        List<AddressDTO> dtoList = addressPage
                .getContent()
                .stream()
                .map(AddressDTO::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, addressPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AddressDTO update(@RequestBody AddressDTO addressDTO, @PathVariable("id") Long id) {
        Address address = addressDTO.toEntity();
        return AddressDTO.fromEntity(addressService.update(address, id));
    }
}