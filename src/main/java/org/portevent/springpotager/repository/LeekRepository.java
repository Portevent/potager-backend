package org.portevent.springpotager.repository;

import org.portevent.springpotager.models.Farmer;
import org.portevent.springpotager.models.Leek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LeekRepository extends JpaRepository<Leek, Long> {

}