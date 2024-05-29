package org.example.facade;

public interface BookingFacade {
    void bookRoom(int roomNumber);
    void cancelBooking(int roomNumber);

    void confirmBooking(int roomNumber);

}
