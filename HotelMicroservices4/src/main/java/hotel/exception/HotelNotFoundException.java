package hotel.exception;

public class HotelNotFoundException extends RuntimeException{

	public HotelNotFoundException() {
		// TODO Auto-generated constructor stub
		
		super("Hotel not found with register id");
	}
	
	public HotelNotFoundException(String sms)
	{
		super(sms);
	}
}
