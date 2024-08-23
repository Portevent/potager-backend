package org.portevent.springpotager.controller;

import org.portevent.springpotager.dto.leek.LeekDto;
import org.portevent.springpotager.mapper.LeekMapper;
import org.portevent.springpotager.service.LeekService;
import org.portevent.springpotager.service.LeekwarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("leeks")
@CrossOrigin
public class LeekController {

    @Autowired
    private LeekService leekService;

    @Autowired
    private LeekwarsService leekwarsService;

    @Autowired
    private LeekMapper leekMapper;

    @GetMapping
    public List<LeekDto> getLeeks() {
        return leekMapper.toDTOs(leekService.getLeeks());
    }


    @GetMapping("/count")
    Long getCount() {
        return leekService.getLeeks().spliterator().getExactSizeIfKnown();
    }


    @GetMapping("/{id}")
    LeekDto get(@PathVariable Long id) {
        return leekMapper.toDTO(leekService.getLeek(id).orElseThrow());
    }


    @DeleteMapping("/{id}")
    void deleteLeek(@PathVariable Long id) {
        leekService.deleteLeek(id);
    }
}
