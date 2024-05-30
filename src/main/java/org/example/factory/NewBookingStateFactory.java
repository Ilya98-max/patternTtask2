package org.example.factory;
import org.example.state.BookingState;
import org.example.state.NewBookingState;

public class NewBookingStateFactory implements BookingStateFactory {
    @Override
    public BookingState createBookingState() {
        return new NewBookingState();
    }
}
