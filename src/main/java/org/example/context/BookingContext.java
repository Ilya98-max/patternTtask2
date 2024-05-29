package org.example.context;

import org.example.state.BookingState;
import org.example.state.NewBookingState;

public class BookingContext {
    private BookingState state;
    private int roomNumber;

    public BookingContext(int roomNumber) {
        this.state = new NewBookingState();
        this.roomNumber = roomNumber;
    }

    public void setState(BookingState state) {
        this.state = state;
    }

    public BookingState getState() {
        return state;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void book() {
        state.bookRoom(this);
    }

    public void cancel() {
        state.cancelBooking(this);
    }

    public void confirm() {
        state.confirmBooking(this);
    }
}