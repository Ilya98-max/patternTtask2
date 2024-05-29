package org.example.repository.impl;
import org.example.context.BookingContext;
import org.example.repository.BookingRepository;
import java.util.ArrayList;
import java.util.List;

public class BookingRepositoryImpl implements BookingRepository {

    private List<BookingContext> bookings = new ArrayList<>();

    @Override
    public BookingContext findByRoom(int roomNumber) {
        return bookings.stream()
                .filter(booking -> booking.getRoomNumber() == roomNumber)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<BookingContext> findAll() {
        return new ArrayList<>(bookings);
    }

    @Override
    public void addBooking(BookingContext booking) {
        bookings.add(booking);
    }

    @Override
    public void removeBooking(int roomNumber) {
        bookings.removeIf(booking -> booking.getRoomNumber() == roomNumber);
    }

}

