package org.example.factory.impl;
import org.example.factory.BookingStateFactory;
import org.example.state.BookingState;
import org.example.state.impl.CancelledBookingState;

public class CancelledBookingStateFactory implements BookingStateFactory {
    @Override
    public BookingState createBookingState() {
        return new CancelledBookingState();
    }
}
