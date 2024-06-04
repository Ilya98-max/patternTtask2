package org.example.state.impl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.context.BookingContext;
import org.example.state.BookingState;

public class CancelledBookingState implements BookingState {
    private static final Logger logger = LogManager.getLogger(CancelledBookingState.class.getName());
    @Override
    public void bookRoom(BookingContext context) {
        context.setState(new NewBookingState());
        logger.info("Room " + context.getRoomNumber() + " is already canceled and cannot be booked again.");
    }

    @Override
    public void cancelBooking(BookingContext context) {
        context.setState(new CancelledBookingState());
        logger.info("Room " + context.getRoomNumber() + " is already canceled.");
    }

    @Override
    public void confirmBooking(BookingContext context) {
        context.setState(new ConfirmedBookingState());
        logger.info("Room " + context.getRoomNumber() + " is already canceled and cannot be confirmed.");
    }
}
