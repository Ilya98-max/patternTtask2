package org.example.states;

import org.example.context.BookingContext;

public class NewBookingState implements BookingState {
    @Override
    public void bookRoom(BookingContext context) {
        System.out.println("Booking room " + context.getRoomNumber());
    }

    @Override
    public void cancelBooking(BookingContext context) {
        context.setState(new CancelledBookingState());
        System.out.println("Cancel a new booking for room " + context.getRoomNumber());
    }
    @Override
    public void confirmBooking(BookingContext context) {
        context.setState(new ConfirmedBookingState());
        System.out.println("Booking is confirmed for room " + context.getRoomNumber());
    }
}
