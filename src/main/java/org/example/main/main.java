
package org.example.main;

import org.example.facade.BookingFacade;
import org.example.facade.HotelBookingFacade;
import org.example.repository.BookingRepository;
import org.example.repository.impl.BookingRepositoryImpl;

public class main {
    public static void main(String[] args) {
        BookingRepository bookingRepository = new BookingRepositoryImpl();
        BookingFacade bookingFacade = new HotelBookingFacade(bookingRepository);


        bookingFacade.bookRoom(101);
        bookingFacade.bookRoom(102);

        bookingFacade.confirmBooking(101);

        bookingFacade.bookRoom(101);


        bookingFacade.cancelBooking(101);
        bookingFacade.cancelBooking(102);
        bookingFacade.cancelBooking(101);
        bookingFacade.cancelBooking(103);
    }
}
