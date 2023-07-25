package hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hotel.entity.Hotel;
import hotel.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/")
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel)
	{
		Hotel hotels=this.hotelService.saveHotel(hotel);
		return ResponseEntity.ok(hotels);
	}
	
	@PutMapping("/")
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel)
	{
		Hotel hotels=this.hotelService.updateHotel(hotel);
		return ResponseEntity.ok(hotels);
	}
	
	@PreAuthorize("hasAuthority('SCOPE_internal')")
	@GetMapping("/{hid}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable("hid") String hid)
	{
		Hotel hotel=this.hotelService.getHotelById(hid);
		
		return ResponseEntity.ok(hotel);
	}
	
	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping("/")
	public ResponseEntity<List<Hotel>> getAllHotel()
	{
		List<Hotel> hotels=this.hotelService.getAllHotel();
		return ResponseEntity.ok(hotels);
	}
	
	@DeleteMapping("/{hid}")
	public void deleteHotel(@PathVariable("hid") String hid)
	{
		this.hotelService.deleteHotel(hid);
	}
}
