package org.example.factory.impl;
import org.example.factory.BookingStateFactory;
import org.example.state.BookingState;
import org.example.state.impl.NewBookingState;

public class NewBookingStateFactory implements BookingStateFactory {
    @Override
    public BookingState createBookingState() {
        return new NewBookingState();
    }
}
