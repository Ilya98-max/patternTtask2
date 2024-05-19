package org.example.facade;

import org.example.context.BookingContext;
import org.example.states.BookingState;
import org.example.states.CancelledBookingState;
import org.example.states.ConfirmedBookingState;
import org.example.states.NewBookingState;

import java.util.ArrayList;
import java.util.List;

public class HotelBookingFacade implements BookingFacade {

    private List<BookingContext> bookings;

    public HotelBookingFacade() {
        bookings = new ArrayList<>();
    }

    @Override
    public void bookRoom(int roomNumber) {
        BookingContext newBooking = GetBookingContext(roomNumber);
        if(newBooking == null) {
            newBooking = new BookingContext(roomNumber);
            bookings.add(newBooking);
            System.out.println("Created a new booking for room " + roomNumber);
        } else {
            newBooking.book();
        }
    }

    @Override
    public void cancelBooking(int roomNumber) {
        if (IsValidRoom(roomNumber)) {
            GetBookingContext(roomNumber).cancel();
            RemoveBookingContext(roomNumber);
        } else {
            System.out.println("Invalid room number " + roomNumber + " to cancel");
        }
    }

    @Override
    public void confirmBooking(int roomNumber) {
        if (IsValidRoom(roomNumber)) {
            GetBookingContext(roomNumber).confirm();
        } else {
            System.out.println("Invalid room number" + roomNumber + " to confirm");
        }

    }

    private boolean IsValidRoom(int roomNumber) {
        boolean valid = false;
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getRoomNumber() == roomNumber) {
                valid = true;
                break;
            }
        }
        return valid;
    }

    private BookingContext GetBookingContext(int roomNumber) {
        BookingContext context = null;
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getRoomNumber() == roomNumber) {
                context = bookings.get(i);
                break;
            }
        }
        return context;
    }

    private void RemoveBookingContext(int roomNumber) {
        if(IsValidRoom(roomNumber)) {
            for (int i = 0; i < bookings.size(); i++) {
                if (bookings.get(i).getRoomNumber() == roomNumber) {
                    bookings.remove(i);
                    break;
                }
            }
        }
        else {
            System.out.println("Invalid room number " + roomNumber);
        }
    }
}
