package hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hotel.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
