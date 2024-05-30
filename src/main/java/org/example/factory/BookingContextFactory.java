package org.example.factory;
import org.example.context.BookingContext;

public interface BookingContextFactory {
    BookingContext createBookingContext(int roomNumber);
}
