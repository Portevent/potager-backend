package org.portevent.springpotager.controller;

import org.portevent.springpotager.dto.farmer.FarmerDto;
import org.portevent.springpotager.dto.farmer.PublicFarmerDto;
import org.portevent.springpotager.mapper.FarmerMapper;
import org.portevent.springpotager.service.FarmerService;
import org.portevent.springpotager.service.LeekwarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("farmers")
@CrossOrigin
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @Autowired
    private LeekwarsService leekwarsService;

    @Autowired
    private FarmerMapper farmerMapper;

    @GetMapping
    public List<FarmerDto> getFarmers() {
        return farmerMapper.toDTOs(farmerService.getFarmers());
    }

    @GetMapping("/fake")
    FarmerDto addFake() {
        return farmerMapper.toDTO(farmerService.saveFarmer(farmerService.getFakeFarmer()));
    }


    @GetMapping("/count")
    Long getCount() {
        return farmerService.getFarmers().spliterator().getExactSizeIfKnown();
    }


    @GetMapping("/{id}")
    FarmerDto get(@PathVariable Long id) {
        return farmerMapper.toDTO(farmerService.getFarmer(id).orElseThrow());
    }


    @GetMapping("/public/{id}")
    PublicFarmerDto getPublic(@PathVariable Long id) {
        return leekwarsService.getFarmer(String.valueOf(id));
    }


    @DeleteMapping("/{id}")
    void deleteFarmer(@PathVariable Long id) {
        farmerService.deleteFarmer(id);
    }
}
