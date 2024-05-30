package org.example.facade;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.context.BookingContext;
import org.example.facade.BookingFacade;
import org.example.factory.BookingContextFactory;
import org.example.factory.BookingStateFactory;
import org.example.repository.BookingRepository;

public class HotelBookingFacade implements BookingFacade {
    private static final Logger logger = LogManager.getLogger(HotelBookingFacade.class.getName());

    private BookingRepository bookingRepository;
    private BookingContextFactory bookingContextFactory;
    private BookingStateFactory newBookingStateFactory;
    private BookingStateFactory cancelledBookingStateFactory;
    private BookingStateFactory confirmedBookingStateFactory;

    public HotelBookingFacade(BookingRepository bookingRepository,
                              BookingContextFactory bookingContextFactory,
                              BookingStateFactory newBookingStateFactory,
                              BookingStateFactory cancelledBookingStateFactory,
                              BookingStateFactory confirmedBookingStateFactory) {
        this.bookingRepository = bookingRepository;
        this.bookingContextFactory = bookingContextFactory;
        this.newBookingStateFactory = newBookingStateFactory;
        this.cancelledBookingStateFactory = cancelledBookingStateFactory;
        this.confirmedBookingStateFactory = confirmedBookingStateFactory;
    }

    @Override
    public void bookRoom(int roomNumber) {
        BookingContext existingBooking = bookingRepository.findByRoom(roomNumber);
        if (existingBooking == null) {
            BookingContext newBooking = bookingContextFactory.createBookingContext(roomNumber);
            bookingRepository.addBooking(newBooking);
            logger.info("Created a new booking for room " + roomNumber);
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
            logger.info("Invalid room number " + roomNumber + " to cancel");
        }
    }

    @Override
    public void confirmBooking(int roomNumber) {
        BookingContext booking = bookingRepository.findByRoom(roomNumber);
        if (booking != null) {
            booking.confirm();
        } else {
            logger.info("Invalid room number " + roomNumber + " to confirm");
        }
    }
}






























