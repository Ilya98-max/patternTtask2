package org.example.facade;
import org.example.context.BookingContext;
import org.example.repository.BookingRepository;


public class HotelBookingFacade implements BookingFacade {

    private BookingRepository bookingRepository;

    public HotelBookingFacade(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void bookRoom(int roomNumber) {
        BookingContext existingBooking = bookingRepository.findByRoom(roomNumber);
        if (existingBooking == null) {
            BookingContext newBooking = new BookingContext(roomNumber);
            bookingRepository.addBooking(newBooking);
            System.out.println("Created a new booking for room " + roomNumber);
        } else {
            existingBooking.book();
        }
    }

    @Override
    public void cancelBooking(int roomNumber) {
        BookingContext booking = bookingRepository.findByRoom(roomNumber);
        if (booking != null) {
            booking.cancel();
            bookingRepository.removeBooking(roomNumber);
        } else {
            System.out.println("Invalid room number " + roomNumber + " to cancel");
        }
    }

    @Override
    public void confirmBooking(int roomNumber) {
        BookingContext booking = bookingRepository.findByRoom(roomNumber);
        if (booking != null) {
            booking.confirm();
        } else {
            System.out.println("Invalid room number " + roomNumber + " to confirm");
        }
    }
}



























