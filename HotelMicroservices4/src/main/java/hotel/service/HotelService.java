package hotel.service;

import java.util.List;

import hotel.entity.Hotel;

public interface HotelService {

	public Hotel saveHotel(Hotel hotel);
	public Hotel updateHotel(Hotel hotel);
	public Hotel getHotelById(String hotelid);
	public List<Hotel> getAllHotel();
	public void deleteHotel(String id);
}
