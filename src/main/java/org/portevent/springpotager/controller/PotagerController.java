package org.portevent.springpotager.controller;

import org.portevent.springpotager.service.AccountService;
import org.portevent.springpotager.service.FarmerService;
import org.portevent.springpotager.service.LeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("potager")
@CrossOrigin
public class PotagerController {

    @Autowired
    private LeekService leekService;

    @Autowired
    private FarmerService farmerService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/counts")
    List<Integer> getCounst() {
        List<Integer> counts = new ArrayList<>();
        counts.add((int) accountService.getAccounts().spliterator().getExactSizeIfKnown());
        counts.add((int) farmerService.getFarmers().spliterator().getExactSizeIfKnown());
        counts.add((int) leekService.getLeeks().spliterator().getExactSizeIfKnown());
        return counts;
    }

}
