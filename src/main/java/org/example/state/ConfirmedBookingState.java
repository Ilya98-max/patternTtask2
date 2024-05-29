package org.example.state;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.context.BookingContext;

public class ConfirmedBookingState implements BookingState {
    private static final Logger logger = LogManager.getLogger(ConfirmedBookingState.class);
    @Override
    public void bookRoom(BookingContext context) {
        logger.info("Room " + context.getRoomNumber() + " is already booked and confirmed.");
    }

    @Override
    public void cancelBooking(BookingContext context) {
        context.setState(new CancelledBookingState());
        logger.info("Cancel confirmed booking for room " + context.getRoomNumber());
    }

    @Override
    public void confirmBooking(BookingContext context) {
        logger.info("Booking for room " + context.getRoomNumber() + " is confirmed.");
    }
}