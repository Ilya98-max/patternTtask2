package org.example.state.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.context.BookingContext;
import org.example.state.BookingState;

public class ConfirmedBookingState implements BookingState {
    private static final Logger logger = LogManager.getLogger(ConfirmedBookingState.class.getName());
    @Override
    public void bookRoom(BookingContext context) {
        context.setState(new NewBookingState());
        logger.info("Room " + context.getRoomNumber() + " is already booked and confirmed.");
    }

    @Override
    public void cancelBooking(BookingContext context) {
        context.setState(new CancelledBookingState());
        logger.info("Cancel confirmed booking for room " + context.getRoomNumber());
    }

    @Override
    public void confirmBooking(BookingContext context) {
        context.setState(new ConfirmedBookingState());
        logger.info("Booking for room " + context.getRoomNumber() + " is confirmed.");
    }
}