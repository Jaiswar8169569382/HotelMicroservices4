package hotel.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.entity.Hotel;
import hotel.exception.HotelNotFoundException;
import hotel.repository.HotelRepository;
import hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	@Override
	public Hotel saveHotel(Hotel hotel) {
		
		String hotelId=UUID.randomUUID().toString();
		hotel.setHotelid(hotelId);
		
		return this.hotelRepository.save(hotel);
	}

	@Override
	public Hotel updateHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return this.hotelRepository.save(hotel);
	}

	@Override
	public Hotel getHotelById(String hotelid) {
		// TODO Auto-generated method stub
		return this.hotelRepository.findById(hotelid).orElseThrow(()->new HotelNotFoundException("Hotel not found with register hotel id"));
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return this.hotelRepository.findAll();
	}

	@Override
	public void deleteHotel(String id) {
		// TODO Auto-generated method stub
		this.hotelRepository.deleteById(id);
	}

	
}
