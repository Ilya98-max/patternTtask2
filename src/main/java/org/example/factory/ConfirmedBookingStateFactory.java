package org.example.factory;


import org.example.state.BookingState;
import org.example.state.ConfirmedBookingState;

public class ConfirmedBookingStateFactory implements BookingStateFactory {
    @Override
    public BookingState createBookingState() {
        return new ConfirmedBookingState();
    }
}
