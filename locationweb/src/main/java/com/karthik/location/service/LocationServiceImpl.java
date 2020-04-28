package com.karthik.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karthik.location.entities.Location;
import com.karthik.location.repos.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository locationRepository; 
	
	public LocationRepository getLocationRepository() {
		return locationRepository;
	}

	public void setLocationRepository(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	@Override
	public Location saveLocation(Location location) {
		return this.locationRepository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return this.locationRepository.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		this.locationRepository.delete(location);
	}

	@Override
	public Location getLocationById(int Id) {
		return this.locationRepository.findById(Id).get();
	}

	@Override
	public List<Location> getAllLocations() {
		return this.locationRepository.findAll();
	}

}
