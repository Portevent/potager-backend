package org.portevent.springpotager.repository;

import org.portevent.springpotager.models.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {

}