package org.example.facade;

import org.example.context.BookingContext;

public interface BookingFacade {
    void bookRoom(int roomNumber);
    void cancelBooking(int roomNumber);

    void confirmBooking(int roomNumber);

}
