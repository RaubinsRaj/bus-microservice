package com.cg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.BusRepository;
import com.cg.entity.Bus;


@RestController
public class BusController {

	@Autowired
	private BusRepository busRepository;
	
	
	@GetMapping(path="buses/displayAllBuses")
	public List<Bus> displayAllBuses()
	{
		List<Bus> buses=new ArrayList<Bus>();
		buses=busRepository.findAll();
		return buses;
	}
	
	
	@PutMapping(path="buses/updateBusDetails/{busId}")
	public Bus updateBusDetails(@PathVariable String busId,@Valid @RequestBody Bus busDetails) throws ResourceNotFoundException
	{
		if (busRepository.findById(busId) != null) {
			Bus existingBus=busRepository.findById(busId).get();
			existingBus.setSeats(busDetails.getSeats());
			existingBus.setFare(busDetails.getFare());
			existingBus.setSrc(busDetails.getSrc());
			existingBus.setDest(busDetails.getDest());
			existingBus.setArrivalTime(busDetails.getArrivalTime());
			existingBus.setDepartureTime(busDetails.getDepartureTime());
			final Bus updatedBus = busRepository.save(existingBus);
			return updatedBus;
			} else
			throw new ResourceNotFoundException("Bus not found for this id :: " + busId);

	}
	
	
	@PostMapping(path="buses/addBusDetails")
	public Bus addBusDetails(@RequestBody Bus bus)
	{
		return busRepository.save(bus);
	}
	
	
	@DeleteMapping(path="buses/deleteBusDetails/{busId}")
	public void deleteBusDetails(String busId) throws ResourceNotFoundException
	{
		if (busRepository.findById(busId) != null) {
			busRepository.deleteById(busId);	
		}
		else
		{
			throw new ResourceNotFoundException("Bus not found for this id :: " + busId);
		}
		
	}
	
	
	//user's/passenger's task
	@GetMapping(path="buses/findBusesBySourceAndDestination/source/{source}/destination/{destination}")
	public List<Bus> findBusesByRoute(@PathVariable String source,@PathVariable String destination) 
	{	
		List<Bus> buses=new ArrayList<Bus>();
		buses=busRepository.findBySrcAndDest(source, destination);
		return buses;
	}
	
	
	//?????
	@GetMapping(path="buses/seatAvailability")
	public String   seatAvailability(int busId)
	{
		
		return "hoga hoga ruk thoda";	
		
	}
	

	
	
	
}