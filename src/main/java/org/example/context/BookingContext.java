package org.example.context;
import org.example.factory.BookingStateFactory;
import org.example.state.BookingState;


public class BookingContext {
    private BookingState state;
    private int roomNumber;

    public BookingContext(int roomNumber, BookingStateFactory stateFactory) {
        this.roomNumber = roomNumber;
        this.state = stateFactory.createBookingState();
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
