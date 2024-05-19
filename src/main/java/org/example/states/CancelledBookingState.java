package org.example.states;

import org.example.context.BookingContext;

public class CancelledBookingState implements BookingState {
    @Override
    public void bookRoom(BookingContext context) {
        System.out.println("Room " + context.getRoomNumber() + " is already canceled and can not be booked again.");
    }

    @Override
    public void cancelBooking(BookingContext context) {
        System.out.println("Room " + context.getRoomNumber() + " is already canceled");
    }

    @Override
    public void confirmBooking(BookingContext context) {
        System.out.println("Room " + context.getRoomNumber() + " is already canceled and can not be confirm.");
    }
}