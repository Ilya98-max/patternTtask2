package org.example.states;

import org.example.context.BookingContext;

public class ConfirmedBookingState implements BookingState {
    @Override
    public void bookRoom(BookingContext context) {
        System.out.println("Room " + context.getRoomNumber() + " is already booked and confirmed.");
    }

    @Override
    public void cancelBooking(BookingContext context) {
        context.setState(new CancelledBookingState());
        System.out.println("Cancel confirmed booking for room " + context.getRoomNumber());
    }

    @Override
    public void confirmBooking(BookingContext context) {
        System.out.println("Booking for room " + context.getRoomNumber() + " is confirmed.");
    }
}