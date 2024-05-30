package org.example.state;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.context.BookingContext;

public class CancelledBookingState implements BookingState {
    private static final Logger logger = LogManager.getLogger(CancelledBookingState.class.getName());
    @Override
    public void bookRoom(BookingContext context) {
        logger.info("Room " + context.getRoomNumber() + " is already canceled and cannot be booked again.");
    }

    @Override
    public void cancelBooking(BookingContext context) {
        logger.info("Room " + context.getRoomNumber() + " is already canceled.");
    }

    @Override
    public void confirmBooking(BookingContext context) {
        logger.info("Room " + context.getRoomNumber() + " is already canceled and cannot be confirmed.");
    }
}