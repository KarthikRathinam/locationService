package com.karthik.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karthik.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
