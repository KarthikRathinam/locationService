package com.karthik.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.karthik.location.entities.Location;
import com.karthik.location.service.LocationService;

@Controller
public class LocationController {

	@Autowired
	LocationService locationService;

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}

	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, 
			ModelMap modelMap) {
		Location saveLocation = this.locationService.saveLocation(location);
		String msg = "Location saved with id:" + saveLocation.getId();
		modelMap.addAttribute("msg", msg);
		return "createLocation";
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> allLocations = this.locationService.getAllLocations();
		modelMap.addAttribute("locations", allLocations);
		return "displayLocations";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int Id, ModelMap modelMap) {
		Location location = this.locationService.getLocationById(Id);
		this.locationService.deleteLocation(location);
		List<Location> allLocations = this.locationService.getAllLocations();
		modelMap.addAttribute("locations", allLocations);
		return "displayLocations";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int Id, ModelMap modelMap) {
		Location location = this.locationService.getLocationById(Id);
		modelMap.addAttribute("location", location);
		return "updateLocation";
	}
	
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, 
			ModelMap modelMap) {
		this.locationService.updateLocation(location);
		List<Location> allLocations = this.locationService.getAllLocations();
		modelMap.addAttribute("locations", allLocations);
		return "displayLocations";
	}
}
