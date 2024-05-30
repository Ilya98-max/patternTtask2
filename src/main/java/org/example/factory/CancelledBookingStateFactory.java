package org.example.factory;
import org.example.state.BookingState;
import org.example.state.CancelledBookingState;

public class CancelledBookingStateFactory implements BookingStateFactory {
    @Override
    public BookingState createBookingState() {
        return new CancelledBookingState();
    }
}
