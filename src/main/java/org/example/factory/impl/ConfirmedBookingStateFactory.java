package org.example.factory.impl;


import org.example.factory.BookingStateFactory;
import org.example.state.BookingState;
import org.example.state.impl.ConfirmedBookingState;

public class ConfirmedBookingStateFactory implements BookingStateFactory {
    @Override
    public BookingState createBookingState() {
        return new ConfirmedBookingState();
    }
}
