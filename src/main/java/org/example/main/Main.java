package org.example.main;

import org.example.facade.BookingFacade;
import org.example.facade.HotelBookingFacade;

public class Main {
    public static void main(String[] args) {
        BookingFacade bookingFacade = new HotelBookingFacade();


        bookingFacade.bookRoom(101);
        bookingFacade.bookRoom(102);

        bookingFacade.confirmBooking(101);

        bookingFacade.bookRoom(101);


        bookingFacade.cancelBooking(101);
        bookingFacade.cancelBooking(102);
        bookingFacade.cancelBooking(101);
    }
}

