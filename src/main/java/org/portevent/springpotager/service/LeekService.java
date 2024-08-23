package org.portevent.springpotager.service;

import net.datafaker.Faker;
import org.portevent.springpotager.models.Leek;
import org.portevent.springpotager.repository.LeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeekService {

    @Autowired
    private LeekRepository leekRepository;

    public Optional<Leek> getLeek(final Long id) {
        return leekRepository.findById(id);
    }

    public List<Leek> getLeeks() {
        return leekRepository.findAll();
    }

    public void deleteLeek(final Long id) {
        leekRepository.deleteById(id);
    }

    public Leek saveLeek(Leek leek) {
        return leekRepository.save(leek);
    }
}
