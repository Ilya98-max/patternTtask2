package org.example.main;

import org.example.facade.BookingFacade;
import org.example.facade.HotelBookingFacade;
import org.example.factory.*;
import org.example.factory.impl.HotelBookingContextFactory;
import org.example.reader.HotelFileReader;
import org.example.repository.BookingRepository;
import org.example.repository.impl.BookingRepositoryImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "booking_data.txt";


        List<Integer> roomNumbers = HotelFileReader.readBookingData(filePath);


        BookingRepository bookingRepository = new BookingRepositoryImpl();
        BookingStateFactory newBookingStateFactory = new NewBookingStateFactory();
        BookingStateFactory cancelledBookingStateFactory = new CancelledBookingStateFactory();
        BookingStateFactory confirmedBookingStateFactory = new ConfirmedBookingStateFactory();
        BookingContextFactory bookingContextFactory = new HotelBookingContextFactory(newBookingStateFactory);


        BookingFacade bookingFacade = new HotelBookingFacade(
                bookingRepository,
                bookingContextFactory,
                newBookingStateFactory,
                cancelledBookingStateFactory,
                confirmedBookingStateFactory
        );


        for (int roomNumber : roomNumbers) {
            bookingFacade.bookRoom(roomNumber);
        }
        for (int roomNumber : roomNumbers) {
            bookingFacade.bookRoom(roomNumber);
            bookingFacade.confirmBooking(roomNumber);
            bookingFacade.cancelBooking(roomNumber);
        }
        bookingFacade.cancelBooking(103);
    }
}



