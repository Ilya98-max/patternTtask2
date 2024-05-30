package org.example.factory.impl;

import org.example.context.BookingContext;
import org.example.factory.BookingContextFactory;
import org.example.factory.BookingStateFactory;

public class HotelBookingContextFactory implements BookingContextFactory {
    private BookingStateFactory newBookingStateFactory;

    public HotelBookingContextFactory(BookingStateFactory newBookingStateFactory) {
        this.newBookingStateFactory = newBookingStateFactory;
    }

    @Override
    public BookingContext createBookingContext(int roomNumber) {
        return new BookingContext(roomNumber, newBookingStateFactory);
    }
}


