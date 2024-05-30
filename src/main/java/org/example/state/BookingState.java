package org.example.state;

import org.example.context.BookingContext;

public interface BookingState {
    void bookRoom(BookingContext context);
    void cancelBooking(BookingContext context);
    void confirmBooking(BookingContext context);
}
